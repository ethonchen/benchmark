package com.toxind.benchmark.jvm.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


public class ReferenceTest {

	public static void main(String[] args) throws InterruptedException {
		ReferenceQueue<A> rq = new ReferenceQueue<A>();
		List<WeakReference<A>> list = new ArrayList<WeakReference<A>>();
		list.add(new WeakReference<A>(new A("xxx"),rq));
		System.gc();
		System.out.println(rq.poll());
		Thread.sleep(1000);
		System.out.println(rq.poll());

	}
	
	static class A{
		public String stc;
		public A(String string) {
			stc = string;
		}

		@Override
		protected void finalize() throws Throwable {
			super.finalize();
			System.out.println(stc + "  gc.......");
		}
	}

}
