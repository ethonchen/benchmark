package com.toxind.benchmark.thrid.current;

import java.util.concurrent.BrokenBarrierException;

import com.toxind.benchmark.thrid.current.util.MethodRun;
import com.toxind.benchmark.thrid.current.util.PerformanceUtil;

public class TestSync{
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		new PerformanceUtil(50000000, 200 ).mesure(new Sync());
		System.out.println("-------");
		new PerformanceUtil(50000000, 200 ).mesure(new NoSync());
	}
	


}

class Sync implements MethodRun{
	@Override
	public synchronized void run() {
	}
}

class NoSync implements MethodRun{
	@Override
	public void run() {
	}
}