package com.toxind.benchmark.thrid.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/spring/a.xml");
		Container con = (Container)context.getBean("container");
		con.ame();
		System.out.println("--------");
		
		con.a();
		
		System.out.println("=======");
		con.sss();
		System.out.println("!!!!!!!!!!");
		con.xxds();
	}
}
