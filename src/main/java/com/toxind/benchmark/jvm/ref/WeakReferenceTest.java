package com.toxind.benchmark.jvm.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

import org.junit.Assert;


public class WeakReferenceTest {

	public static void main(String[] args) throws InterruptedException {
		ReferenceQueue queue = new ReferenceQueue();  
		PhantomReference ref = new PhantomReference(new A("x."), queue);  
		  
		Assert.assertNull(ref.get());  
		  
		Object obj = null;  
		obj = queue.poll();  
		  
		Assert.assertNull(obj);  
		  
		System.gc();  
		  
		Thread.sleep(1000);  
		  
		System.gc();  
		  
		Assert.assertNull(ref.get());  
		obj = queue.poll();  
		Assert.assertNotNull(obj);  

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
