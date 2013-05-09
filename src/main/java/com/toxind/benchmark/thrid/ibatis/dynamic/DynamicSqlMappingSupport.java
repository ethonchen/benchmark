package com.toxind.benchmark.thrid.ibatis.dynamic;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import com.ibatis.sqlmap.client.SqlMapException;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;
import com.toxind.benchmark.thrid.ibatis.dynamic.model.DynamicSql;
import com.toxind.benchmark.thrid.ibatis.dynamic.service.DynamicSqlService;

public class DynamicSqlMappingSupport extends Thread{

	public static ReadWriteLock lock = new ReentrantReadWriteLock();
	
	private static final Log log = LogFactory.getLog(DynamicSqlMappingSupport.class);
	private ApplicationContext applicationContext;
	private DynamicSqlMapClient client;
	public DynamicSqlMappingSupport(ApplicationContext applicationContext,DynamicSqlMapClient client){
		this.applicationContext = applicationContext;
		this.client = client;
	}
	
	private Date lastModifyTime = new Date(0);

	@Override
	public void run() {		
		DynamicSqlService service = (DynamicSqlService)applicationContext.getBean("dynamicSqlServiceImpl");
		init(service);
		while(true){
			try{
				Map<String,List<DynamicSql>> map = service.getAddAndRemoveSql(lastModifyTime);				

				addStatement(map.get("listAdd"));
				removeStatement(map.get("listRemove"));
			}catch (Exception e) {
				log.error(e);
				// ignore sql exception...
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				//ignore!!!!!!
			}
			
		}
	}
	private void init(DynamicSqlService service) {
		List<DynamicSql> list = service.getAddSql();
		addStatement(list);
	}
	private void addStatement(List<DynamicSql> list) {
		if(list != null && list.size() > 0){
			lock.writeLock().lock();
			try{			
				for(DynamicSql sql : list){
					if(sql.getGmtModified().after(lastModifyTime)){
						lastModifyTime = sql.getGmtModified();
					}
					
					String namespace = sql.getNamespace();
					String subId = sql.getSqlId();
					StringBuilder mappingStr = new StringBuilder();
					mappingStr.append("<?xml version=\"1.0\" encoding=\"GBK\"?>").append("\r\n");
					mappingStr.append("<!DOCTYPE sqlMap PUBLIC \"-//iBATIS.com//DTD SQL Map 2.0//EN\" \"http://www.ibatis.com/dtd/sql-map-2.dtd\">").append("\r\n");
					mappingStr.append("<sqlMap namespace=\"")
							  .append(namespace)
							  .append("\">")
							  .append("\r\n");
					mappingStr.append("<select id=\"")
							  .append(subId).append("\" ")
							  .append(sql.getParameterType())
							  .append(" ")
							  .append(sql.getResultType())
							  .append(" >")
							  .append("\r\n");
					mappingStr.append(sql.getContentSql()).append("\r\n");
					mappingStr.append("</select>").append("\r\n");
					mappingStr.append("</sqlMap>").append("\r\n");
					
					InputStream is = new ByteArrayInputStream(mappingStr.toString().getBytes());
					this.client.reParseSqlMap(is);
				}
			}finally{
				lock.writeLock().unlock();
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	private void removeStatement(List<DynamicSql> list) {
		if(list != null && list.size() > 0){
			lock.writeLock().lock();
			try{			
				for(DynamicSql sql : list){
					if(sql.getGmtModified().after(lastModifyTime)){
						lastModifyTime = sql.getGmtModified();
					}

					String namespace = sql.getNamespace();
					String subId = sql.getSqlId();
					String id = namespace+"."+subId;
					try {
						this.client.delegate.getMappedStatement(id);
						if(this.client.delegate instanceof DynamicSqlMapExecutorDelegate){
							DynamicSqlMapExecutorDelegate dsed = (DynamicSqlMapExecutorDelegate)this.client.delegate;
							SqlMapExecutorDelegate dele = dsed.getDelegate();
							Field f = dele.getClass().getDeclaredField("mappedStatements");
							f.setAccessible(true);
							Map map = (Map)f.get(dele);
							if ( map.containsKey(id)) {
								map.remove(id);
							}
						}
						
					} catch (SqlMapException ignore) {
						log.error(ignore);
					} catch (Exception e) {
						log.error(e);
					}					
				}
			}finally{
				lock.writeLock().unlock();
			}
		}
	}
}
