package com.toxind.benchmark.thrid.spring.annotationscope;

import java.sql.Statement;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Container {
	@Resource(name="runningStatement1")
	private ConcurrentHashMap<Long, Statement> runningStatement;

	

	
	public void testUtil(){
		System.out.println(runningStatement.hashCode());
		System.out.println(runningStatement.size());
	}

	@Autowired
	private A a;
	public void me(){
		System.out.println(a);
		a.getAA();
	}
	public ConcurrentHashMap<Long, Statement> getRunningStatement() {
		return runningStatement;
	}
	public void setRunningStatement(
			ConcurrentHashMap<Long, Statement> runningStatement) {
		this.runningStatement = runningStatement;
	}

}
