package com.toxind.benchmark.thrid.ibatis.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AbcDao extends SqlMapClientDaoSupport {

	public List getEntity(Map<String, String> params){
		if(params == null){
			System.out.println("=======================");
			return getSqlMapClientTemplate().queryForList("abc.T2");
		}
		else{
			return getSqlMapClientTemplate().queryForList("abc.T1",params);
		}
	}
	
	public List getForIdx(Map<String, String> params){
		return getSqlMapClientTemplate().queryForList("abc.T_idx",params);		
	}
	
	public List getForUp(Map<String, String> params){
		return getSqlMapClientTemplate().queryForList("abc.T_up",params);		
	}
}
