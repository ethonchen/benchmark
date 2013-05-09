package com.toxind.benchmark.thrid.ibatis.ibatisaspect;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;

public class IbatisTest {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("com/ibatis/ibatisaspect/application.xml");
	
	public static void main(String[] args) throws Exception{
//		DragoonClient.setUriStatEnable(false);     //用于 web访问中的 uri，默认关闭
//		DragoonClient.setLog4jStatEnable(true);    //用于Exception监控项的采集
//		DragoonClient.setNapoliStatEnable(false);  //napoli统计，如果使用了napoli的客户端，请开启
//		DragoonClient.setNapoliMQServerStatEnable(false); //napoli统计,如果使用了napoli客户端，请开启
//		DragoonClient.start("dy_sql");
		
		Map m = ctx.getBeansOfType(SqlMapExecutorDelegate.class);
		for(Object o : m.keySet()){
			System.out.println(o + " --> " + m.get(o));
		}
		IAbcDao ad = (IAbcDao)ctx.getBean("abcDao");
		//printList(l);
		while(true){
			printListCount(ad.getEntity(null));
			printListCount(ad.getEntity());
			//printList(ad.getEntity(null));
			
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
	
	public static void printListCount(List list){
		System.out.println(list.size());
	}
}
