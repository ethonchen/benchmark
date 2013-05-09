package com.toxind.benchmark.thrid.current.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class Runner implements Runnable {

    private Integer runnerId;
    private CyclicBarrier barrier;
    private Random rand = new Random();
    private AtomicInteger runSteps = new AtomicInteger(0);

    public Integer getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Integer runnerId) {
        this.runnerId = runnerId;
    }

    public Runner(CyclicBarrier barrier, Integer id) {
        this.barrier = barrier;
        this.runnerId = id;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                int currSteps = rand.nextInt(10); // 每秒随机跑多少米
                runSteps.addAndGet(currSteps);  //用了Atomic这里也不用加 synchronized 等等同步元语了，一些简单的算法能自动加同步锁
                Thread.sleep(1000); //休眠1秒
            }
            barrier.await();
        } catch (InterruptedException e) {
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public StringBuffer stepsBuffer() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < runSteps.get(); i++) {
            buffer.append("*");
        }
        return buffer;
    }
}

class Umpire implements Runnable {

    private CyclicBarrier barrier;
    private Integer runnerCount;
    private ExecutorService service;
    private List<Runner> runnerList = new ArrayList<Runner>();
    private Integer trackLength;
    private volatile boolean isQuit = false;
    private List<Runner> winner = new ArrayList<Runner>();//要考虑可能会有多个运动员同时跑到终点的情况。

    public Umpire(CyclicBarrier barrier, int runnerCount,
            ExecutorService service, Integer trackLength) {
        this.barrier = barrier;
        this.runnerCount = runnerCount;
        this.service = service;
        this.trackLength = trackLength;
    }
    
    public void run() {
        try {
            System.out.println("裁判到位......");
            for (int i = 0; i < runnerCount; i++) {
                Runner runner = new Runner(barrier, i);
                runnerList.add(runner);
                service.execute(runner);
            }
            StringBuffer trace = new StringBuffer();
            trace.append("                  ");
            for (int i = 0; i < trackLength; i++) {
                trace.append("=");
            }
            while (!Thread.interrupted()) {
                Thread.sleep(500);
                if(!isQuit){
                    System.out.print(trace + "\n");
                    for (int i = 0; i < runnerList.size(); i++) {
                        Integer runnerId = runnerList.get(i).getRunnerId();
                        StringBuffer runnerStapes = runnerList.get(i).stepsBuffer();
                        if (runnerStapes.length() >= trackLength) {
                            winner.add(runnerList.get(i));
                            isQuit = true;
                            service.shutdownNow();
                        } //一般情况下可能没有0号运动员，把ID+1当成编号
                        System.out.println("赛跑运动员 " + (runnerId+1) + " ; 跑到 "
                                + runnerStapes +" "+runnerStapes.length());
                    }
                    System.out.print(trace + "\n");
                }
            }
            
            for(int i=0;i<winner.size();i++){ //输出编号+1
                System.out.println("赛跑运动员 "+(winner.get(i).getRunnerId()+1)+" 胜出!!!");
            }

            barrier.await();
        } catch (InterruptedException e) {
            System.out.println("裁判员离场!");
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class RunnerTest {
    public static void main(String[] args) {
        final int runnerCount = 10;
        final int trackLength = 100;

        CyclicBarrier barrier = new CyclicBarrier(runnerCount);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Umpire(barrier, runnerCount, service, trackLength));
    }
}