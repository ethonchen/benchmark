package com.toxind.benchmark.thrid.current.util;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PerformanceUtil {
	ThreadPoolExecutor executor = null;
	long requestCount;
	int threads;
	CyclicBarrier barrier;
	public PerformanceUtil(long requestCount,int threads){
		this.requestCount = requestCount;
		this.threads = threads;
		executor = new ThreadPoolExecutor(threads,threads,100,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());
	}
	public PerformanceUtil(long requestCount,int threads,CyclicBarrier barrier){
		this.requestCount = requestCount;
		this.threads = threads;
		this.barrier = barrier;
		executor = new ThreadPoolExecutor(threads,threads,100,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());
	}

	public void mesure(final MethodRun run) throws InterruptedException, BrokenBarrierException{
		this.preRun(run);
		while(executor.getActiveCount() != 0){
		}
		System.out.println("now the system is running ... " );
		long begin = System.currentTimeMillis();
		for(long i = 0 ; i < requestCount ; i++){
			executor.execute(new Runnable() {				
				@Override
				public void run() {
					run.run();
				}
			});
		}
		executor.shutdown();
		while(!executor.isTerminated()){			
		}
		long end = System.currentTimeMillis();
		System.out.println("the request is : " + requestCount + " and thread is "+ threads + " and costs " + (end-begin) + " and pre request cost " + (end-begin) / requestCount);
		if(barrier != null)barrier.await();
	}
	
	public void preRun(final MethodRun run){
		final CountDownLatch cd = new CountDownLatch(threads );
		for(int i = 0 ; i < threads; i++){
			executor.execute(new Runnable() {				
				@Override
				public void run() {
					try {
						cd.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					run.run();
				}
			});
			cd.countDown();
		}
		for(int i = 0 ; i < 50000 ; i ++ ){
			executor.execute(new Runnable() {
				@Override
				public void run() {
					run.run();
				}
			});
		}
	}
	
	public void done(){
		executor.shutdown();
		while(executor.isTerminated())
			System.out.println(" completed : " + executor.isTerminated() );
	}
	
}
