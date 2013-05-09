package com.toxind.benchmark.thrid.ibatis.abatordrag.test.dt;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DtTestDao  extends SqlMapClientDaoSupport{

	public void printTest(){
		List list=this.getSqlMapClientTemplate().queryForList("test.abcd1");
		printList(list);
	}
	
	public static void printList(List list){
		for(Object o : list){
			if(o instanceof Map){
				Map m = (Map)o;
				for( Object okey : m.keySet()){
					System.out.println(okey + " : " + m.get(okey));
				}
			}
		}
	}
}
