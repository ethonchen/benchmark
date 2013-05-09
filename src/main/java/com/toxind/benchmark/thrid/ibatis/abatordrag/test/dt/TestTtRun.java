package com.toxind.benchmark.thrid.ibatis.abatordrag.test.dt;

import java.util.Random;

import org.springframework.context.ApplicationContext;

import com.ibatis.sqlmap.client.SqlMapException;

public class TestTtRun implements Runnable{
	ApplicationContext ctx;
	String bid;
	Random random = new Random();
	public TestTtRun(ApplicationContext ctx , String bid){
		this.ctx = ctx;
		this.bid = bid;
	}
	@Override
	public void run() {
		DtTestDao dao = (DtTestDao)ctx.getBean("dtTestDao");
		while(true){
			try{
			dao.printTest();
			}catch(SqlMapException e){
				if(e.getMessage().startsWith("There is no statement named")){
					
					throw new RuntimeException("ID not set yet.");
				}
				System.err.println("not read yet.." + e);
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}