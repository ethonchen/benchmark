package com.toxind.benchmark.thrid.ibatis.ibatisinject;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class IbatisTest2 {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("com/ibatis/ibatisinject/application1.xml");
	public static Map<String,String> map = new ConcurrentHashMap<String, String>();
	static{
		map.put("id", "apptest.id1");
		map.put("resultClass", "java.util.HashMap");
		map.put("sqlContent", "select * from hello");
	}
	
	public static void main(String[] args) throws Exception{
//		DragoonClient.setUriStatEnable(false);     //用于 web访问中的 uri，默认关闭
//		DragoonClient.setLog4jStatEnable(true);    //用于Exception监控项的采集
//		DragoonClient.setNapoliStatEnable(false);  //napoli统计，如果使用了napoli的客户端，请开启
//		DragoonClient.setNapoliMQServerStatEnable(false); //napoli统计,如果使用了napoli客户端，请开启
//		DragoonClient.start("dy_sql");
		
		for(int i = 0 ; i < 1 ; i++)
		new Thread(new Runnable() {
			
			@Override
			public void run() {
//				while(true){
					
					
					IAbcDao ad = (IAbcDao)ctx.getBean("abcDao");
			//		Map<String, Object> params = new HashMap<String, Object>();
			//		params.put("param_1", 4);
					printList(ad.queryForList("apptest.id1", null));
					System.out.println("####################################################");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//				}
			}
		}).start();
		
		


		
	}
	
	public static void printList(List list){
		for(Object o : list){
			if(o instanceof Map){
				Map m = (Map)o;
				StringBuilder str = new StringBuilder();
				for( Object okey : m.keySet()){
//					System.out.println(okey + " : " + m.get(okey));
					str.append(okey).append(" ");
				}
				System.out.println(str.toString());
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
