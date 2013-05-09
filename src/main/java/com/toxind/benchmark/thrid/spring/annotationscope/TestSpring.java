package com.toxind.benchmark.thrid.spring.annotationscope;

import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/spring/annotationscope/a.xml");
		Container con = (Container)context.getBean("container");
//		con.me();r
//		con.me();
//		con.me();
//		System.out.println(context.getBean("a"));
//		System.out.println(context.getBean("a"));
//		System.out.println(context.getBean("a"));
		con.testUtil();
		con.me();
		AA aa = (AA)context.getBean("AA");
		A a = (A)context.getBean("a");
		Map m1 = con.getRunningStatement();
		Map m2 = aa.getRunningStatement();
		Map m3 = a.getRunningStatement();
		
		System.out.println(m1==m2);
		System.out.println(m1==m3);
		System.out.println(m3==m2);
		
		System.out.println(context.getBean("xxx"));
		System.out.println(aa.getXxx());
	}
}
