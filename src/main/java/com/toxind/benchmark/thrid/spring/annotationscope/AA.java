package com.toxind.benchmark.thrid.spring.annotationscope;

import java.sql.Statement;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class AA {
	
	private String xxx;
	@Resource
	private ConcurrentHashMap<Long, Statement> runningStatement;
	public void me(){
		System.out.println(runningStatement.hashCode());
	}
	public ConcurrentHashMap<Long, Statement> getRunningStatement() {
		return runningStatement;
	}
	public void setRunningStatement(
			ConcurrentHashMap<Long, Statement> runningStatement) {
		this.runningStatement = runningStatement;
	}
	public String getXxx() {
		return xxx;
	}
	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
}
