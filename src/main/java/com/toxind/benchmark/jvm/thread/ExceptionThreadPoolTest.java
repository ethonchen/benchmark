package com.toxind.benchmark.jvm.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExceptionThreadPoolTest {

	public static void main(String[] args) {

		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(1900);
		ThreadPoolExecutor pool = new ThreadPoolExecutor(10,100,10,TimeUnit.SECONDS,queue,new ThreadPoolExecutor.CallerRunsPolicy());
		int count = 5;
		CountDownLatch latch = new CountDownLatch(count);
		InterruptHelper helper = new InterruptHelper(Thread.currentThread(), null);
		System.out.println(NullPointerException.class.isAssignableFrom(RuntimeException.class));
		for(int i = 0 ; i < count; i++){
			ExceptionTRun er = new ExceptionTRun();
			er.setLatch(latch);
//			er.setParentThread(Thread.currentThread());			
			er.setInterruptHelper(helper);
			pool.execute(er);
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			
			System.err.println("########");
			throw helper.getException();
			
			
		}
		System.out.println("done.. " + ExceptionTRun.count);

	}
}


