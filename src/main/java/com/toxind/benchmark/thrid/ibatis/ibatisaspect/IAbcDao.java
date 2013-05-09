package com.toxind.benchmark.thrid.ibatis.ibatisaspect;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;

@Repository
public interface IAbcDao{

	public List getEntity(Map<String, String> params);
	public List getEntity();
}
