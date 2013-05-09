package com.toxind.benchmark.jvm.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import org.junit.Assert;


public class SoftReferenceTest {

	public static void main(String[] args) throws InterruptedException {
	    ReferenceQueue queue = new ReferenceQueue();  
	    WeakReference ref = new WeakReference(new A("a"), queue);  
	    Assert.assertNotNull(ref.get());  
	  
	    Object obj = null;  
	    obj = queue.poll();  
	    Assert.assertNull(obj);  
	  
	    System.gc();  
	  Thread.sleep(50);
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
