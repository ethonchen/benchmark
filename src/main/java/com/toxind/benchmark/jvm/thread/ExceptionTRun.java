package com.toxind.benchmark.jvm.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ExceptionTRun implements Runnable {

	CountDownLatch latch = null;
	public static AtomicInteger count = new AtomicInteger(0);

	InterruptHelper interruptHelper;
	@Override
	public void run() {
		try {
			int i = count.incrementAndGet();

			if (i == 2) {
				throw new RuntimeException("..wrong..");
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(" # " + i);


		}
		catch (RuntimeException e) {
			System.err.println(" catch : " + e.getMessage());
			this.interruptHelper.setException(e);
			this.interruptHelper.getParentThread().interrupt();
		}
		finally {
			
			latch.countDown();
		}

	}

	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}


	public void setInterruptHelper(InterruptHelper interruptHelper) {
		this.interruptHelper = interruptHelper;
	}

}
