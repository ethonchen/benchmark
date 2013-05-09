package com.toxind.benchmark.jvm.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class BlockQueueTest {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(100);
        
		ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 10, 10, TimeUnit.SECONDS, workQueue);
        new Thread(new ShowQueue(workQueue)).start();
        new Thread(new ShowQueue(workQueue)).start();
        new Thread(new ShowQueue(workQueue)).start();
        new Thread(new ShowQueue(workQueue)).start();
        new Thread(new ShowQueue(workQueue)).start();
        for(int i = 0 ; i < 80 ; i ++){
        	pool.execute(new Runner());
        	if(i % 3 == 0)
        		Thread.sleep(300);
        }
        
        
//        Thread.sleep(90000);
	}
	


}

class ShowQueue implements Runnable{
	BlockingQueue<Runnable> queue;
	public ShowQueue(BlockingQueue<Runnable> queue){
			this.queue = queue;
	}
	
	public void run() {
		while(true){
			System.out.println("############# " + queue.size());
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}

class Runner implements Runnable{
	public static AtomicInteger count = new AtomicInteger(1);

	public void run() {
		try {
			int i = count.getAndIncrement();
			System.out.println( i + "====begin====");
			Thread.sleep(5000);
			System.out.println( i + "====end  ====");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
