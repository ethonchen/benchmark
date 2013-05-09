package com.toxind.benchmark.thrid.spring.annotationscope;

import java.sql.Statement;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope(value="prototype")
public class A {
	@Resource
	private ConcurrentHashMap<Long, Statement> runningStatement;

	@Autowired
	private AA aa;
	
	public void getAA(){
		System.out.println(runningStatement.hashCode());
		aa.me();
	}

	public ConcurrentHashMap<Long, Statement> getRunningStatement() {
		return runningStatement;
	}

	public void setRunningStatement(
			ConcurrentHashMap<Long, Statement> runningStatement) {
		this.runningStatement = runningStatement;
	}	
	
}
