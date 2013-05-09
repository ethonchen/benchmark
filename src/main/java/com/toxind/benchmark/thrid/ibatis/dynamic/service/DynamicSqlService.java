package com.toxind.benchmark.thrid.ibatis.dynamic.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.toxind.benchmark.thrid.ibatis.dynamic.model.DynamicSql;

public interface DynamicSqlService {
	
	List<DynamicSql> getAddSql();
	
	Map<String,List<DynamicSql>> getAddAndRemoveSql(Date lastModifyTime);
}
