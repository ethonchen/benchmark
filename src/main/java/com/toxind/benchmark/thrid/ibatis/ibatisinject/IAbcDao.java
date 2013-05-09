package com.toxind.benchmark.thrid.ibatis.ibatisinject;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;


public interface IAbcDao  {

	public List getEntity(Map<String, String> params);
	
	public List queryForList(String id ,Map<String, Object> params);
}
