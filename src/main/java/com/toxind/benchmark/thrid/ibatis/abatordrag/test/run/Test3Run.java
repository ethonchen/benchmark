package com.toxind.benchmark.thrid.ibatis.abatordrag.test.run;

import java.util.Date;
import java.util.Random;

import org.springframework.context.ApplicationContext;

import com.toxind.benchmark.thrid.ibatis.abatordrag.test.dao.Test3DAO;
import com.toxind.benchmark.thrid.ibatis.abatordrag.test.model.Test3;

public class Test3Run implements Runnable{
	ApplicationContext ctx;
	String bid;
	Random random = new Random();
	public Test3Run(ApplicationContext ctx , String bid){
		this.ctx = ctx;
		this.bid = bid;
	}
	@Override
	public void run() {
		Test3DAO dao = (Test3DAO)ctx.getBean("test3DAOImpl");
		for(int i = 0 ; i < 2000000 ; i ++){
			Test3 t1 = new Test3();
			t1.setA(i + 1);
			t1.setB(i + "test");
			t1.setC(new Date(i * 1000l * 60 *60 *24));
			t1.setD("test");
			t1.setId(i + 1l);
			dao.insert(t1);
		}
	}	
}