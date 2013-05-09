package com.toxind.benchmark.jvm.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TRun implements Runnable{

	public static AtomicInteger count = new AtomicInteger(0);
	@Override
	public void run() {
		count.incrementAndGet();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		count.decrementAndGet();
		
	}

}
