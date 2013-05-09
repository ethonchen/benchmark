package com.toxind.benchmark.thrid.ibatis.ibatis.test;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.Resource;
import com.ibatis.common.xml.NodeletException;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.builder.xml.SqlMapConfigParser;
import com.ibatis.sqlmap.engine.builder.xml.SqlMapParser;
import com.ibatis.sqlmap.engine.builder.xml.XmlParserState;
import com.ibatis.sqlmap.engine.config.SqlMapConfiguration;
import com.ibatis.sqlmap.engine.impl.ExtendedSqlMapClient;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;
public class DySqlMapClient extends SqlMapClientImpl {
	private SqlMapClient client = null;
	private SqlMapParser mapParser = null;
	private SqlMapConfigParser configParser = null;
	private Resource[] configLocations = null;
	private List <FileDesc> descList = null;
	private DySqlMapExecutorDelegate myDelegate = null;
	
	private Map<String, FileDesc> statementMap = null;
	private Map<FileDesc, List<String>> fileStatementMap = null;
	
	private DySqlMapClient(SqlMapExecutorDelegate delegate) {
		super(delegate);
	}
	public DySqlMapClient(SqlMapClient client, SqlMapParser mapParser, SqlMapConfigParser configParser, Resource[] configLocations) {
		super(new DySqlMapExecutorDelegate(((ExtendedSqlMapClient)client).getDelegate()));
		this.myDelegate = (DySqlMapExecutorDelegate) this.delegate;
		this.myDelegate.setClient(this);
		this.client = client;
		this.mapParser = mapParser;
		this.configParser = configParser;
		this.configLocations = configLocations;
		initFileDescList();
		initStatementMap();
		initState();
	}
	
	public FileDesc getFileDescUseId(String id) {
		FileDesc fd = statementMap.get(id);
		return fd;
	}
	public void refreshFileDesc(String id, long tm) {
		FileDesc fd = getFileDescUseId(id);
		fd.setTm(tm);
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
	
	private void initFileDescList() {
		descList = new ArrayList<FileDesc>();
		for ( int i = 0; i < configLocations.length; i++) {
			try {
				String path = configLocations[i].getFile().getAbsolutePath();
				descList.addAll(SqlMapConfigUtils.readSqlMapFileMapping(path));
			} catch (IOException e) {}
		}
	}
	
	private void initStatementMap() {
		this.statementMap = new HashMap<String, FileDesc>();
		this.fileStatementMap = new HashMap<FileDesc, List<String>>();
		for ( Iterator <FileDesc> it = descList.listIterator(); it.hasNext(); ) {
			FileDesc desc = it.next();
			List <String> list = SqlMapConfigUtils.readSqlMap(desc);
			for ( Iterator <String> i = list.listIterator(); i.hasNext(); ) {
				String id = i.next();
				statementMap.put(id, desc);
			}
			this.fileStatementMap.put(desc, list);
		}
	}
	
	/*@Override
	public void flushDataCache() {
		this.client.flushDataCache();
	}
	@Override
	public void flushDataCache(String cacheId) {
		this.client.flushDataCache(cacheId);
	}
	@Override
	public SqlMapSession getSession() {
		return this.client.getSession();
	}
	@Override
	public SqlMapSession openSession() {
		return this.client.openSession();
	}
	@Override
	public SqlMapSession openSession(Connection conn) {
		return this.client.openSession(conn);
	}
	@Override
	public int delete(String id) throws SQLException {
		return this.client.delete(id);
	}
	@Override
	public int delete(String id, Object parameterObject) throws SQLException {
		return this.client.delete(id, parameterObject);
	}
	@Override
	public int executeBatch() throws SQLException {
		return this.client.executeBatch();
	}
	@Override
	public List executeBatchDetailed() throws SQLException, BatchException {
		return this.client.executeBatchDetailed();
	}
	@Override
	public Object insert(String id) throws SQLException {
		return this.client.insert(id);
	}
	@Override
	public Object insert(String id, Object parameterObject) throws SQLException {
		return this.insert(id, parameterObject);
	}
	@Override
	public List queryForList(String id) throws SQLException {
		return this.client.queryForList(id);
	}
	@Override
	public List queryForList(String id, Object parameterObject)
			throws SQLException {
		return this.client.queryForList(id, parameterObject);
	}
	@Override
	public List queryForList(String id, int skip, int max) throws SQLException {
		return this.client.queryForList(id, skip, max);
	}
	@Override
	public List queryForList(String id, Object parameterObject, int skip,
			int max) throws SQLException {
		return this.client.queryForList(id, parameterObject, skip, max);
	}
	@Override
	public Map queryForMap(String id, Object parameterObject, String keyProp)
			throws SQLException {
		return this.client.queryForMap(id, parameterObject, keyProp);
	}
	@Override
	public Map queryForMap(String id, Object parameterObject, String keyProp,
			String valueProp) throws SQLException {
		return this.client.queryForMap(id, parameterObject, keyProp, valueProp);
	}
	@Override
	public Object queryForObject(String id) throws SQLException {
		return this.client.queryForObject(id);
	}
	
	@Override
	public Object queryForObject(String id, Object parameterObject)
			throws SQLException {
		return this.client.queryForObject(id, parameterObject);
	}
	@Override
	public Object queryForObject(String id, Object parameterObject,
			Object resultObject) throws SQLException {
		return this.client.queryForObject(id, parameterObject, resultObject);
	}
	@Override
	public PaginatedList queryForPaginatedList(String id, int pageSize)
			throws SQLException {
		
		return this.client.queryForPaginatedList(id, pageSize);
	}
	@Override
	public PaginatedList queryForPaginatedList(String id,
			Object parameterObject, int pageSize) throws SQLException {
		
		return this.client.queryForPaginatedList(id, parameterObject, pageSize);
	}
	@Override
	public void queryWithRowHandler(String id, RowHandler rowHandler)
			throws SQLException {
		
		this.client.queryWithRowHandler(id, rowHandler);
	}
	@Override
	public void queryWithRowHandler(String id, Object parameterObject,
			RowHandler rowHandler) throws SQLException {
		this.client.queryWithRowHandler(id, parameterObject, rowHandler);
	}
	@Override
	public void startBatch() throws SQLException {
		this.client.startBatch();
	}
	@Override
	public int update(String id) throws SQLException {
		return this.client.update(id);
	}
	@Override
	public int update(String id, Object parameterObject) throws SQLException {
		return this.client.update(id, parameterObject);
	}
	@Override
	public void commitTransaction() throws SQLException {
		this.client.commitTransaction();
	}
	@Override
	public void endTransaction() throws SQLException {
		this.client.endTransaction();
	}
	@Override
	public Connection getCurrentConnection() throws SQLException {
		return this.client.getCurrentConnection();
	}
	@Override
	public DataSource getDataSource() {
		return this.client.getDataSource();
	}
	@Override
	public Connection getUserConnection() throws SQLException {
		return this.client.getUserConnection();
	}
	@Override
	public void setUserConnection(Connection connnection) throws SQLException {
		this.client.setUserConnection(connnection);
	}
	@Override
	public void startTransaction() throws SQLException {
		this.client.startTransaction();
	}
	@Override
	public void startTransaction(int transactionIsolation) throws SQLException {
		this.client.startTransaction(transactionIsolation);
	}*/
}
