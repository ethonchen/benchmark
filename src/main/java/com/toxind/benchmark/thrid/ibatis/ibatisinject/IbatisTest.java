package com.toxind.benchmark.thrid.ibatis.ibatisinject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class IbatisTest {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("com/ibatis/ibatisinject/application2.xml");
	public static Map<String,String> map = new ConcurrentHashMap<String, String>();
	static{
		map.put("id", "apptest.id1");
		map.put("resultClass", "java.util.HashMap");
		map.put("sqlContent", "select * from hello");
	}
	public static void main(String[] args) throws Exception{
		map.put("id", "apptest.id1");
		map.put("resultClass", "java.util.HashMap");
		map.put("sqlContent", "select * from t_abc where a >= #param_1#");
		
		AbcDao ad = (AbcDao)ctx.getBean("abcDao");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("param_1", 4);
		printList(ad.queryForList("apptest.id1", params));
		System.out.println("####################################################");
		
		map.put("id", "apptest.id2");
		map.put("resultClass", "com.ibatisinject.ModelA");
		StringBuilder str = new StringBuilder();
		str.append("select * from t_abc ")
		   .append("<dynamic prepend=\"where\"> ")
		   .append("<isGreaterThan prepend=\"and\" property=\"param_1\" compareValue=\"0\"> ")
		   .append("a > #param_1# ")
		   .append("</isGreaterThan> ")
		   .append("</dynamic> ")
		   .append("order by a ");
		map.put("sqlContent", str.toString());
		params = new HashMap<String, Object>();
		params.put("param_1", 2);
		printModel(ad.queryForList("apptest.id2", params));
		
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
	public static void printModel(List list){
		for(Object o : list){
			if(o instanceof ModelA){
				ModelA m = (ModelA)o;
				System.out.println(m.getA() + " : " + m.getC());
			}
		}
	}
	public static void printListCount(List list){
		System.out.println(list.size());
	}
}
