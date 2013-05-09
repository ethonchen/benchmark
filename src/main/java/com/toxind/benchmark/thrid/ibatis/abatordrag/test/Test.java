package com.toxind.benchmark.thrid.ibatis.abatordrag.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.toxind.benchmark.thrid.ibatis.abatordrag.test.run.ATest1Run;

public class Test {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("com/ibatis/abatordrag/test/application.xml");
	
	public static void main(String[] args) {
//		DragoonClient.setUriStatEnable(false);     //用于 web访问中的 uri，默认关闭
//		DragoonClient.setLog4jStatEnable(true);    //用于Exception监控项的采集
//		DragoonClient.setNapoliStatEnable(false);  //napoli统计，如果使用了napoli的客户端，请开启
//		DragoonClient.setNapoliMQServerStatEnable(false); //napoli统计,如果使用了napoli客户端，请开启
//		DragoonClient.start("aaa");
		
//		new Thread(new Test1Run(ctx, "1")).start();
//		new Thread(new Test2Run(ctx, "1")).start();
//		new Thread(new Test3Run(ctx, "1")).start();
//		new Thread(new Test4Run(ctx, "1")).start();
//		new Thread(new Test5Run(ctx, "1")).start();
		new Thread(new ATest1Run(ctx, "1")).start();
//		new Thread(new TestTtRun(ctx, "1")).start();
	}

}

