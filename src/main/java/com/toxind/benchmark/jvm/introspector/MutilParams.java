package com.toxind.benchmark.jvm.introspector;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MutilParams {

	public void method(Object...objects){
		System.out.println(objects);
	}
	
	public static void main(String[] args) {
		MutilParams p = new MutilParams();
		p.method();
		
		p.method(1,"21",1.2,new Date());
		
		Object[] o = new Object[2];
		o[0] = 121;
		o[1] = "xxx";
		p.method(o);
		
		List list = new ArrayList();
		list.add(121);
		list.add("xxx");
		p.method(list);
		
	}
}
