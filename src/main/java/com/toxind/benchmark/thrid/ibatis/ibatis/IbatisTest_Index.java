package com.toxind.benchmark.thrid.ibatis.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IbatisTest_Index {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("com/ibatis/application_index.xml");
	
	public static void main(String[] args) throws Exception{
		AbcDao ad = (AbcDao)ctx.getBean("abcDao");
		while(true){
			Map map = new HashMap();
			map.put("a", 1000);
			printList(ad.getForIdx(map));
			Thread.sleep(5000);
		}
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
