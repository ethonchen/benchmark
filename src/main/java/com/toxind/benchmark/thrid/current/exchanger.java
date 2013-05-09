package com.toxind.benchmark.thrid.current;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class exchanger {

	public static void main(String[] args) {
		final Exchanger<String> e = new Exchanger<String>();
		 
		new Thread() {
		    @Override
		    public void run() {
		        long id = Thread.currentThread().getId();
		        String s = "abc";
		        System.out.println("线程 [" + id + "] 算出 " + s);
		 
		        try {
		            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
		            System.out.println("线程 [" + id + "] 收到 " + e.exchange(s));
		        } catch (InterruptedException ex) {
		            ex.printStackTrace();
		        }
		    }
		}.start();
		 
		new Thread() {
		    @Override
		    public void run() {
		        long id = Thread.currentThread().getId();
		        String s = "xyz";
		        System.out.println("线程 [" + id + "] 算出 " + s);
		 
		        try {
		            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
		            System.out.println("线程 [" + id + "] 收到 " + e.exchange(s));
		        } catch (InterruptedException ex) {
		            ex.printStackTrace();
		        }
		    }
		}.start(); 
	}
}
