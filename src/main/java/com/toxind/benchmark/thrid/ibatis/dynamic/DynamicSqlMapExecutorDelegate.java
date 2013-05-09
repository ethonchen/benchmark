package com.toxind.benchmark.thrid.ibatis.dynamic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.sqlmap.client.SqlMapException;
import com.ibatis.sqlmap.client.event.RowHandler;
import com.ibatis.sqlmap.engine.cache.CacheModel;
import com.ibatis.sqlmap.engine.exchange.DataExchangeFactory;
import com.ibatis.sqlmap.engine.execution.BatchException;
import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;
import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMap;
import com.ibatis.sqlmap.engine.mapping.result.ResultMap;
import com.ibatis.sqlmap.engine.mapping.result.ResultObjectFactory;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import com.ibatis.sqlmap.engine.scope.StatementScope;
import com.ibatis.sqlmap.engine.transaction.Transaction;
import com.ibatis.sqlmap.engine.transaction.TransactionManager;
import com.ibatis.sqlmap.engine.type.TypeHandlerFactory;
@SuppressWarnings("deprecation")
public class DynamicSqlMapExecutorDelegate extends SqlMapExecutorDelegate {
	private SqlMapExecutorDelegate delegate = null;
	private DynamicSqlMapClient client = null;
	
	private static final Log log = LogFactory.getLog(DynamicSqlMapExecutorDelegate.class);
	
	public void setClient(DynamicSqlMapClient client) {
		this.client = client;
	}
	public DynamicSqlMapExecutorDelegate(SqlMapExecutorDelegate delegate) {
		super();
		this.delegate = delegate;
	}
	
	@Override
	public void addCacheModel(CacheModel model) {
		this.delegate.addCacheModel(model);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void addMappedStatement(MappedStatement ms) {		
		try {
			this.delegate.getMappedStatement(ms.getId());
			Field f = this.delegate.getClass().getDeclaredField("mappedStatements");
			f.setAccessible(true);
			Map map = (Map)f.get(this.delegate);
			if ( map.containsKey(ms.getId())) {
				map.remove(ms.getId());
			}
		} catch (SqlMapException ignore) {
//			log.error(ignore);
		} catch (Exception e) {
			log.error(e);
		}
		this.delegate.addMappedStatement(ms);
	}
	@Override
	public void addParameterMap(ParameterMap map) {
		this.delegate.addParameterMap(map);
	}
	@Override
	public void addResultMap(ResultMap map) {
		this.delegate.addResultMap(map);
	}
	@Override
	protected void autoCommitTransaction(SessionScope sessionScope,
			boolean autoStart) throws SQLException {		
		try {
			Method m = this.delegate.getClass().getDeclaredMethod("autoCommitTransaction", SessionScope.class, Boolean.class);
			m.setAccessible(true);
			m.invoke(this.delegate, sessionScope, autoStart);
		} catch (Exception e) {
			if ( e instanceof SQLException) {
				throw (SQLException) e;
			}
			throw new RuntimeException(e);
		}
	}
	@Override
	protected void autoEndTransaction(SessionScope sessionScope,
			boolean autoStart) throws SQLException {
		try {
			Method m = this.delegate.getClass().getDeclaredMethod("autoEndTransaction", SessionScope.class, Boolean.class);
			m.setAccessible(true);
			m.invoke(this.delegate, sessionScope, autoStart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if ( e instanceof SQLException) {
				throw (SQLException) e;
			}
			throw new RuntimeException(e);
		}
	}
	@Override
	protected Transaction autoStartTransaction(SessionScope sessionScope,
			boolean autoStart, Transaction trans) throws SQLException {
		
		try {
			Method m = this.delegate.getClass().getDeclaredMethod("autoStartTransaction", SessionScope.class, Boolean.class, Transaction.class);
			m.setAccessible(true);
			return (Transaction) m.invoke(this.delegate, sessionScope, autoStart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if ( e instanceof SQLException) {
				throw (SQLException) e;
			}
			throw new RuntimeException(e);
		}
	}
	@Override
	protected SessionScope beginSessionScope() {
		try {
			Method m = this.delegate.getClass().getDeclaredMethod("beginSessionScope");
			m.setAccessible(true);
			return (SessionScope) m.invoke(this.delegate);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	protected StatementScope beginStatementScope(SessionScope sessionScope,
			MappedStatement mappedStatement) {
		try {
			Method m = this.delegate.getClass().getDeclaredMethod("beginSessionScope", SessionScope.class, MappedStatement.class);
			m.setAccessible(true);
			return (StatementScope) m.invoke(this.delegate, sessionScope, mappedStatement);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void commitTransaction(SessionScope sessionScope)
			throws SQLException {
		this.delegate.commitTransaction(sessionScope);
	}
	@Override
	public int delete(SessionScope sessionScope, String id, Object param)
			throws SQLException {
		return this.delegate.delete(sessionScope, id, param);
	}
	@Override
	protected void endSessionScope(SessionScope sessionScope) {
		try {
			Method m = this.delegate.getClass().getDeclaredMethod("endSessionScope", SessionScope.class);
			m.setAccessible(true);
			m.invoke(this.delegate, sessionScope);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	protected void endStatementScope(StatementScope statementScope) {
		try {
			Method m = this.delegate.getClass().getDeclaredMethod("endStatementScope", StatementScope.class);
			m.setAccessible(true);
			m.invoke(this.delegate, statementScope);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void endTransaction(SessionScope sessionScope) throws SQLException {
		this.delegate.endTransaction(sessionScope);
	}
	@Override
	public boolean equals(Object obj) {
		return this.delegate.equals(obj);
	}
	@Override
	public int executeBatch(SessionScope sessionScope) throws SQLException {
		return this.delegate.executeBatch(sessionScope);
	}
	@Override
	public List executeBatchDetailed(SessionScope sessionScope)
			throws SQLException, BatchException {
		return this.delegate.executeBatchDetailed(sessionScope);
	}
	@Override
	public void flushDataCache() {
		this.delegate.flushDataCache();
	}
	@Override
	public void flushDataCache(String id) {
		this.delegate.flushDataCache(id);
	}
	@Override
	public CacheModel getCacheModel(String id) {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.getCacheModel(id);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}
	}
	@Override
	public Iterator getCacheModelNames() {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.getCacheModelNames();
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}
	}
	@Override
	public DataExchangeFactory getDataExchangeFactory() {
		return this.delegate.getDataExchangeFactory();
	}
	@Override
	public DataSource getDataSource() {
		return this.delegate.getDataSource();
	}
	@Override
	public MappedStatement getMappedStatement(String id) {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.getMappedStatement(id);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}
	}
	@Override
	public Iterator getMappedStatementNames() {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.getMappedStatementNames();
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}		
	}
	@Override
	public int getMaxTransactions() {
		return this.delegate.getMaxTransactions();
	}
	@Override
	public ParameterMap getParameterMap(String id) {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.getParameterMap(id);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}
	}
	@Override
	public Iterator getParameterMapNames() {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.getParameterMapNames();
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}		
	}
	@Override
	public ResultMap getResultMap(String id) {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.getResultMap(id);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}		
	}
	@Override
	public Iterator getResultMapNames() {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.getResultMapNames();
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}
	}
	@Override
	public ResultObjectFactory getResultObjectFactory() {
		return this.delegate.getResultObjectFactory();
	}
	@Override
	public SqlExecutor getSqlExecutor() {
		return this.delegate.getSqlExecutor();
	}
	@Override
	public Transaction getTransaction(SessionScope sessionScope) {
		return this.delegate.getTransaction(sessionScope);
	}
	@Override
	public TransactionManager getTxManager() {
		return this.delegate.getTxManager();
	}
	@Override
	public TypeHandlerFactory getTypeHandlerFactory() {
		return this.delegate.getTypeHandlerFactory();
	}
	@Override
	public int hashCode() {
		return this.delegate.hashCode();
	}
	@Override
	public Object insert(SessionScope sessionScope, String id, Object param)
			throws SQLException {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.insert(sessionScope, id, param);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}		
	}
	@Override
	public boolean isCacheModelsEnabled() {
		return this.delegate.isCacheModelsEnabled();
	}
	@Override
	public boolean isEnhancementEnabled() {
		return this.delegate.isEnhancementEnabled();
	}
	@Override
	public boolean isForceMultipleResultSetSupport() {
		return this.delegate.isForceMultipleResultSetSupport();
	}
	@Override
	public boolean isLazyLoadingEnabled() {
		return this.delegate.isLazyLoadingEnabled();
	}
	@Override
	public boolean isStatementCacheEnabled() {
		return this.delegate.isStatementCacheEnabled();
	}
	@Override
	public boolean isUseColumnLabel() {
		return this.delegate.isUseColumnLabel();
	}
	@Override
	public List queryForList(SessionScope sessionScope, String id,
			Object paramObject, int skip, int max) throws SQLException {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.queryForList(sessionScope, id, paramObject, skip, max);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}
	}
	@Override
	public List queryForList(SessionScope sessionScope, String id,
			Object paramObject) throws SQLException {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.queryForList(sessionScope, id, paramObject);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}
	}
	@Override
	public Map queryForMap(SessionScope sessionScope, String id,
			Object paramObject, String keyProp, String valueProp)
			throws SQLException {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.queryForMap(sessionScope, id, paramObject, keyProp, valueProp);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}		
	}
	@Override
	public Map queryForMap(SessionScope sessionScope, String id,
			Object paramObject, String keyProp) throws SQLException {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.queryForMap(sessionScope, id, paramObject, keyProp);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}

	}
	@Override
	public Object queryForObject(SessionScope sessionScope, String id,
			Object paramObject, Object resultObject) throws SQLException {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.queryForObject(sessionScope, id, paramObject, resultObject);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}
	}
	@Override
	public Object queryForObject(SessionScope sessionScope, String id,
			Object paramObject) throws SQLException {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.queryForObject(sessionScope, id, paramObject);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}
	}
	@Override
	public PaginatedList queryForPaginatedList(SessionScope sessionScope,
			String id, Object paramObject, int pageSize) throws SQLException {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.queryForPaginatedList(sessionScope, id, paramObject, pageSize);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}
		
	}
	@Override
	public void queryWithRowHandler(SessionScope sessionScope, String id,
			Object paramObject, RowHandler rowHandler) throws SQLException {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			this.delegate.queryWithRowHandler(sessionScope, id, paramObject, rowHandler);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}
		
	}
	@Override
	public void setCacheModelsEnabled(boolean cacheModelsEnabled) {
		this.delegate.setCacheModelsEnabled(cacheModelsEnabled);
	}
	@Override
	public void setEnhancementEnabled(boolean enhancementEnabled) {
		this.delegate.setEnhancementEnabled(enhancementEnabled);
	}
	@Override
	public void setForceMultipleResultSetSupport(
			boolean forceMultipleResultSetSupport) {
		this.delegate.setForceMultipleResultSetSupport(forceMultipleResultSetSupport);
	}
	@Override
	public void setLazyLoadingEnabled(boolean lazyLoadingEnabled) {
		this.delegate.setLazyLoadingEnabled(lazyLoadingEnabled);
	}
	@Override
	public void setResultObjectFactory(ResultObjectFactory resultObjectFactory) {
		this.delegate.setResultObjectFactory(resultObjectFactory);
	}
	@Override
	public void setStatementCacheEnabled(boolean statementCacheEnabled) {
		this.delegate.setStatementCacheEnabled(statementCacheEnabled);
	}
	@Override
	public void setTxManager(TransactionManager txManager) {
		this.delegate.setTxManager(txManager);
	}
	@Override
	public void setUseColumnLabel(boolean useColumnLabel) {
		this.delegate.setUseColumnLabel(useColumnLabel);
	}
	@Override
	public void setUserProvidedTransaction(SessionScope sessionScope,
			Connection userConnection) {
		this.delegate.setUserProvidedTransaction(sessionScope, userConnection);
	}
	@Override
	public void startBatch(SessionScope sessionScope) {
		this.delegate.startBatch(sessionScope);
	}
	@Override
	public void startTransaction(SessionScope sessionScope,
			int transactionIsolation) throws SQLException {
		this.delegate.startTransaction(sessionScope, transactionIsolation);
	}
	@Override
	public void startTransaction(SessionScope sessionScope) throws SQLException {
		this.delegate.startTransaction(sessionScope);
	}
	@Override
	public int update(SessionScope sessionScope, String id, Object param)
			throws SQLException {
		DynamicSqlMappingSupport.lock.readLock().lock();
		try{
			return this.delegate.update(sessionScope, id, param);
		}finally{
			DynamicSqlMappingSupport.lock.readLock().unlock();
		}
	}
	public SqlMapExecutorDelegate getDelegate() {
		return delegate;
	}
	
}
