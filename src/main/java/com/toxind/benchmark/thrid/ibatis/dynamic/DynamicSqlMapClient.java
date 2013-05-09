package com.toxind.benchmark.thrid.ibatis.dynamic;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import com.ibatis.common.xml.NodeletException;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.builder.xml.SqlMapConfigParser;
import com.ibatis.sqlmap.engine.builder.xml.SqlMapParser;
import com.ibatis.sqlmap.engine.builder.xml.XmlParserState;
import com.ibatis.sqlmap.engine.config.SqlMapConfiguration;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;

public class DynamicSqlMapClient extends SqlMapClientImpl{
	
	private static final Log logger = LogFactory.getLog(DynamicSqlMapClient.class);
	
	private SqlMapParser mapParser = null;
	private SqlMapConfigParser configParser = null;
	
	private DynamicSqlMapExecutorDelegate myDelegate = null;

	
	private DynamicSqlMapClient(SqlMapExecutorDelegate delegate) {
		super(delegate);
	}
	public DynamicSqlMapClient(SqlMapClient client, SqlMapParser mapParser, SqlMapConfigParser configParser, Resource[] configLocations,ApplicationContext applicationContext) {
		super(new DynamicSqlMapExecutorDelegate(((SqlMapClientImpl)client).getDelegate()));
		this.myDelegate = (DynamicSqlMapExecutorDelegate) this.delegate;
		this.myDelegate.setClient(this);
		this.mapParser = mapParser;
		this.configParser = configParser;				
		initState();
		new DynamicSqlMappingSupport(applicationContext, this).start();
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
			logger.error(e);
		} catch (IllegalArgumentException e) {
			logger.error(e);
		} catch (NoSuchFieldException e) {
			logger.error(e);
		} catch (IllegalAccessException e) {
			logger.error(e);
		}
	}	

}
