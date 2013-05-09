package com.toxind.benchmark.thrid.performance.javassistcglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.DecimalFormat;
import java.util.concurrent.Callable;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

public class ProxyPerformanceComparison2 {

	public static void main(String[] args) throws Exception {
		Callable<Integer> jdkProxy = (Callable<Integer>) Proxy
				.newProxyInstance(ClassLoader.getSystemClassLoader(),
						new Class[] { Callable.class }, new JdkHandler(
								new Counter()));
		ProxyFactory f = new ProxyFactory();
		f.setInterfaces(new Class[] { Callable.class });
		Class c = f.createClass();
		Callable<Integer> cglibProxy = (Callable<Integer>) c.newInstance();
		((ProxyObject) cglibProxy).setHandler(new JavaAssitInterceptor(
				new Counter()));
		for (int i2 = 0; i2 < 10; i2++) {
			iterate(jdkProxy, "JDK Proxy: ");
			iterate(cglibProxy, "JAVAASSIST: ");
			System.err.println();
		}

	}

	static final DecimalFormat format = new DecimalFormat();

	static void iterate(Callable<Integer> callable, String label)
			throws Exception {
		int count = 10000000;
		long time = System.currentTimeMillis();
		int total = 0;
		for (int i = 0; i < count; i++) {
			total += callable.call();
		}
		time = System.currentTimeMillis() - time;
		System.err.println(label + format.format(count * 1000 / time)
				+ " calls/s");

	}

	static class JdkHandler implements InvocationHandler {
		final Object delegate;

		JdkHandler(Object delegate) {
			this.delegate = delegate;
		}

		public Object invoke(Object object, Method method, Object[] objects)
				throws Throwable {
			return method.invoke(delegate, objects);
		}

	}

	static class JavaAssitInterceptor implements MethodHandler {
		final Object delegate;

		JavaAssitInterceptor(Object delegate) {
			this.delegate = delegate;
		}

		public Object invoke(Object self, Method m, Method proceed,
				Object[] args) throws Throwable {
			return m.invoke(delegate, args);
		}

	}

	static class Counter implements Callable<Integer> {
		int count = 0;

		public Integer call() throws Exception {
			return count++;
		}
	}

}