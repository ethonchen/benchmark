package com.toxind.benchmark.thrid.ibatis.ibatisaspect;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;

@Repository
public class AbcDao extends SqlMapClientDaoSupport  implements IAbcDao{

	public List getEntity(Map<String, String> params){
//		SqlMapClientImpl sci = (SqlMapClientImpl)getSqlMapClient();
//		SqlMapExecutorDelegate delegate = sci.getDelegate();
//		delegate.getMappedStatementNames();
		
		return getSqlMapClientTemplate().queryForList("abc.T2");		
	}
	
	public List getEntity(){
//		SqlMapClientImpl sci = (SqlMapClientImpl)getSqlMapClient();
//		SqlMapExecutorDelegate delegate = sci.getDelegate();
//		delegate.getMappedStatementNames();
		
		return getSqlMapClientTemplate().queryForList("T3.xx");		
	}
}
