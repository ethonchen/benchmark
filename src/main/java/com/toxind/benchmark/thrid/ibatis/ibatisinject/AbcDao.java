package com.toxind.benchmark.thrid.ibatis.ibatisinject;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class AbcDao extends SqlMapClientDaoSupport implements IAbcDao{

	public List getEntity(Map<String, String> params){
		if(params == null){
			System.out.println("=======================");
			return getSqlMapClientTemplate().queryForList("abc1.T2");
		}
		else{
			return getSqlMapClientTemplate().queryForList("abc.T1",params);
		}
	}	
	
	public List queryForList(String id ,Map<String, Object> params){
		
		return getSqlMapClientTemplate().queryForList(id,params);		
	}
}
