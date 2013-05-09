package com.toxind.benchmark.thrid.performance.reflectintrospection;

import java.lang.reflect.Method;
import java.text.DecimalFormat;

import org.springframework.beans.BeanUtils;

public class PerformanceComp {

	public static void main(String[] args) throws NoSuchMethodException, Exception {
		ClazzA clz = new ClazzA();
		for(int i = 0 ; i < 20 ; i ++){
			reflectionCall(clz);
//			cacheIntro(clz);
//			normalCall(clz);
		}
		System.out.println();
		
	}
	static final DecimalFormat format = new DecimalFormat();
	public static void reflectionCall(Object o) throws Exception, NoSuchMethodException{
		int count = 10000000;
		long time = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			Method method = o.getClass().getMethod("method");
			method.invoke(o);
		}
		time = System.currentTimeMillis() - time;
		System.err.println("reflection : " + format.format(count * 1000 / time)
				+ " calls/s");
	}
	public static void normalCall(Object o) throws Exception, NoSuchMethodException{
		int count = 10000000;
		long time = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			ClazzA a = (ClazzA)o;
			a.method();
		}
		time = System.currentTimeMillis() - time;
		System.err.println("normal call : " + format.format(count * 1000 / time)
				+ " calls/s");
	}
	public static void cacheIntro(Object o) throws Exception, NoSuchMethodException{
		int count = 10000000;
		long time = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			Method method = BeanUtils.findMethod(o.getClass(), "method", null);
			method.invoke(o);
		}
		time = System.currentTimeMillis() - time;
		System.err.println("intro : " + format.format(count * 1000 / time)
				+ " calls/s");
	}

}

class ClazzA{
	int i = 1;
	public void method(){		
		i++;
	}
}
