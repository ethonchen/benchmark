package com.toxind.benchmark.thrid.ibatis.ibatis.test.b;

import com.toxind.benchmark.thrid.ibatis.ibatis.test.a.GA;

public class GB extends GA{

	private GA ga ;
	public GB(GA ga){
		this.ga = ga;
	}
	
	@Override
	protected void me1(String xx) {
//		ga.me1(xx);
	}
}
