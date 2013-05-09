package com.toxind.benchmark.thrid.ibatis.ibatisaspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(200)
public class AspectClass {
	
	@Pointcut("execution(public * org.springframework.orm.ibatis.support.SqlMapClientDaoSupport.*(..))")
	public void poc1(){}
	
	@Around("poc1()")
	public Object around1(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println(pjp.getTarget().getClass());
		System.out.println(pjp.getThis().getClass());
		System.out.println(pjp.toLongString());		
		System.out.println("------begin around-----");	
		
		Object o = pjp.proceed();
		
		System.out.println("------end around-------");
		
		return o;
	}
	
}
