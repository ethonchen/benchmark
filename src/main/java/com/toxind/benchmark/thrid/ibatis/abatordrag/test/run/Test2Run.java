package com.toxind.benchmark.thrid.ibatis.abatordrag.test.run;

import java.util.Date;
import java.util.Random;

import org.springframework.context.ApplicationContext;

import com.toxind.benchmark.thrid.ibatis.abatordrag.test.dao.Test2DAO;
import com.toxind.benchmark.thrid.ibatis.abatordrag.test.model.Test2;

public class Test2Run implements Runnable{
	ApplicationContext ctx;
	String bid;
	Random random = new Random();
	public Test2Run(ApplicationContext ctx , String bid){
		this.ctx = ctx;
		this.bid = bid;
	}
	@Override
	public void run() {
		Test2DAO dao = (Test2DAO)ctx.getBean("test2DAOImpl");
		for(int i = 0 ; i < 2000000 ; i ++){
			Test2 t1 = new Test2();
			t1.setA(i + 1);
			t1.setB(i + "test");
			t1.setC(new Date(i * 1000l * 60 *60 *24));
			t1.setD("test");
			t1.setId(i + 1l);
			dao.insert(t1);
		}
	}	
}