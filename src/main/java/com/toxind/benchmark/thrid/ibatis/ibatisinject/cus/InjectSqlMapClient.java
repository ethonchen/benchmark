package com.toxind.benchmark.thrid.ibatis.ibatisinject.cus;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import org.springframework.core.io.Resource;
import com.ibatis.common.xml.NodeletException;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.builder.xml.SqlMapConfigParser;
import com.ibatis.sqlmap.engine.builder.xml.SqlMapParser;
import com.ibatis.sqlmap.engine.builder.xml.XmlParserState;
import com.ibatis.sqlmap.engine.config.SqlMapConfiguration;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;
public class InjectSqlMapClient extends SqlMapClientImpl {
	
	private SqlMapParser mapParser = null;
	private SqlMapConfigParser configParser = null;
	
	private InjectSqlMapExecutorDelegate myDelegate = null;
	
	
	private InjectSqlMapClient(SqlMapExecutorDelegate delegate) {
		super(delegate);
	}
	public InjectSqlMapClient(SqlMapClient client, SqlMapParser mapParser, SqlMapConfigParser configParser, Resource[] configLocations) {
		super(new InjectSqlMapExecutorDelegate(((SqlMapClientImpl)client).getDelegate()));
		this.myDelegate = (InjectSqlMapExecutorDelegate) this.delegate;
		this.myDelegate.setClient(this);
		this.mapParser = mapParser;
		this.configParser = configParser;
		
		initState();
	}
	

	public void reParseSqlMap(InputStream is) {
		try {
			this.mapParser.parse(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NodeletException e) {
			e.printStackTrace();
		}
	}
	
	public void initState() {
		try {
			Field f = this.configParser.getClass().getDeclaredField("state");
			f.setAccessible(true);
			XmlParserState state = (XmlParserState) f.get(this.configParser);
			Field configFiled = state.getClass().getDeclaredField("config");
			configFiled.setAccessible(true);
			SqlMapConfiguration impl = (SqlMapConfiguration) configFiled.get(state);
			Field clientField = impl.getClass().getDeclaredField("client");
			clientField.setAccessible(true);
			clientField.set(impl, this);
			Field delegateField = impl.getClass().getDeclaredField("delegate");
			delegateField.setAccessible(true);
			delegateField.set(impl, this.myDelegate);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
