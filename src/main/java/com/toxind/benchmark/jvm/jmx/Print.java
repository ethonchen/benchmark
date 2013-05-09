package com.toxind.benchmark.jvm.jmx;

public class Print implements PrintMXBean{

	String x ;
	public Print(String x){
		this.x = x;
	}
	@Override
	public void something(String name) {
		System.out.println("Hi there , " + name + " in class " + x);
	}

	@Override
	public String nice(long l) {
		return " hi ,go " + l;
	}

	@Override
	public Long getXxa() {
		return 121l;
	}

	@Override
	public Long getHell(String x) {
		return Long.parseLong(x);
	}

	@Override
	public Yy getYy() {
		return new Yy();
	}

}
