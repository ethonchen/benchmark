package com.toxind.benchmark.jvm.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException {
		new Thread(){
			public void run() {		while(true){
				System.out.println(TRun.count.get());
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}};
		}.start();
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(1900);
		ThreadPoolExecutor pool = new ThreadPoolExecutor(10,100,10,TimeUnit.SECONDS,queue,new ThreadPoolExecutor.CallerRunsPolicy());
		int count = 2000;
		for(int i = 0 ; i < count; i++){
			pool.execute(new TRun());
		}


	}
}


