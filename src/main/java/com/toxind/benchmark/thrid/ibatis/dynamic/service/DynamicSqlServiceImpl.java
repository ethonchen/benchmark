package com.toxind.benchmark.thrid.ibatis.dynamic.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toxind.benchmark.thrid.ibatis.dynamic.dao.DynamicSqlDAO;
import com.toxind.benchmark.thrid.ibatis.dynamic.model.DynamicSql;
import com.toxind.benchmark.thrid.ibatis.dynamic.model.DynamicSqlExample;

@Service
public class DynamicSqlServiceImpl implements DynamicSqlService{

	@Autowired
	private DynamicSqlDAO dynamicSqlDAOImpl;
	
	private static final short DYNAMIC_SQL_ADD = (short)2;
	private static final short DYNAMIC_SQL_REMOVE = (short)3;
	

	@Override
	public List<DynamicSql> getAddSql() {
		DynamicSqlExample example = new DynamicSqlExample();
		example.createCriteria().andStateEqualTo(DYNAMIC_SQL_ADD);
		return dynamicSqlDAOImpl.selectByExampleWithBLOBs(example);
	}

	@Override
	public Map<String,List<DynamicSql>> getAddAndRemoveSql(Date lastModifyTime) {
		DynamicSqlExample example = new DynamicSqlExample();				
		example.createCriteria()
			   .andStateIn(Arrays.asList(DYNAMIC_SQL_ADD,DYNAMIC_SQL_REMOVE))
			   .andGmtModifiedGreaterThan(lastModifyTime);
		
		List<DynamicSql> list = dynamicSqlDAOImpl.selectByExampleWithBLOBs(example);
		
		List<DynamicSql> listAdd = new ArrayList<DynamicSql>();
		List<DynamicSql> listRemove = new ArrayList<DynamicSql>();
		for(DynamicSql sql : list){
			if(sql.getState() == DYNAMIC_SQL_ADD){
				listAdd.add(sql);
			}else if(sql.getState() == DYNAMIC_SQL_REMOVE){
				listRemove.add(sql);
			}
		}
		Map<String,List<DynamicSql>> result = new HashMap<String,List<DynamicSql>>();
		result.put("listAdd", listAdd);
		result.put("listRemove", listRemove);
		return result;
	}


}
