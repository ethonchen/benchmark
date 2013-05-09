package com.toxind.benchmark.thrid.ibatis.abatordrag.test.run;

import java.util.Random;

import org.springframework.context.ApplicationContext;

import com.toxind.benchmark.thrid.ibatis.abatordrag.test.dao.Test1DAO;
import com.toxind.benchmark.thrid.ibatis.abatordrag.test.model.Test1;

public class ATest1Run implements Runnable{
	ApplicationContext ctx;
	String bid;
	Random random = new Random();
	public ATest1Run(ApplicationContext ctx , String bid){
		this.ctx = ctx;
		this.bid = bid;
	}
	@Override
	public void run() {
		Test1DAO dao = (Test1DAO)ctx.getBean("test1DAOImpl");
		while(true){
			Test1 t1 = dao.selectByPrimaryKey((long) random.nextInt(2000000));
			System.out.println(t1.getA() + " == " + t1.getB() + " " + t1.getC());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}