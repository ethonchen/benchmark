package com.toxind.benchmark.thrid.ibatis.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IbatisTest2 {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("com/ibatis/application.xml");
	private static ApplicationContext ctx2 = new ClassPathXmlApplicationContext(new String[]{"com/ibatis/application2.xml"},ctx);
	
	public static void main(String[] args) throws Exception{
		AbcDao ad = (AbcDao)ctx.getBean("abcDao");
		AbcDao adSub = (AbcDao)ctx2.getBean("abcDao");
		//printList(l);
		while(true){
			System.out.println("--> this is parent");
			printModel(ad.getEntity(null));
			System.out.println("--> this is sub");
			printModel(adSub.getEntity(null));
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
