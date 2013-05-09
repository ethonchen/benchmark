package com.toxind.benchmark.thrid.ibatis.autoinject;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class AbcDao extends SqlMapClientDaoSupport {

	public  AbcDao (){
		System.out.println(this.getSqlMapClient());
	}
	
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
