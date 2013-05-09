package com.toxind.benchmark.jvm.mem;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.ArrayList;
import java.util.List;


public class MemTest {

	public static void main(String[] args) {
		MemoryMXBean mmx = ManagementFactory.getMemoryMXBean();
		System.out.println(mmx.getHeapMemoryUsage().getMax() + "  =====   " + mmx.getHeapMemoryUsage().getUsed());
		long begin = mmx.getHeapMemoryUsage().getUsed();
		List<NewObject> list = new ArrayList<NewObject>();
		int count = 2000000;
		for(int i = 0 ; i < count ; i++){
			list.add(new NewObject());
		}
		System.out.println(mmx.getHeapMemoryUsage().getMax() + "  =====   " + mmx.getHeapMemoryUsage().getUsed());
		long end = mmx.getHeapMemoryUsage().getUsed();
		System.out.println((end - begin) / 1024 / 1024);
		System.out.println(" in com .. " + count * 17  + "   ---- real " + (end - begin));
	}

}

class NewObject {
    int count;
    boolean flag;
    Object ob;
}