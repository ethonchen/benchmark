package com.toxind.benchmark.thrid.spring.factorybean;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/spring/annotationscope/a.xml");
	Container con = (Container)context.getBean("container");

}
