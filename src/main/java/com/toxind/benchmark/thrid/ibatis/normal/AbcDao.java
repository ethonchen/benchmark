package com.toxind.benchmark.thrid.ibatis.normal;

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

}
