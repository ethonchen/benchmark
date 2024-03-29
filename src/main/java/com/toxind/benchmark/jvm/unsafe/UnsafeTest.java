/*
 *Copyright 2010, the original author or authors.  All rights reserved.
 */
package com.toxind.benchmark.jvm.unsafe;

import java.lang.reflect.Field;
import java.util.logging.Logger;

import sun.misc.Unsafe;

/**
 * 通过反射获取rt.jar下的Unsafe类
 * 
 * @author <a href="mailto:xiao_jiang51@163.com">xiao jiang</a>
 * @version %I%, %G%
 * @history 2010-12-23
 */
public class UnsafeTest {
	private static Logger log = Logger.getAnonymousLogger();
	
	@SuppressWarnings("restriction")
	public static void main(String[] args) {
		
		Unsafe unsafe = UnsafeSupport.getInstance();
		// 这个很牛
		// unsafe.allocateMemory(1000000000l);

		Class clazz = AnalyzedTarget.class;
		Field[] fields = clazz.getDeclaredFields();
		log.info("fieldName:fieldOffset");
		// 获取属性偏移量，可以通过这个偏移量给属性设置
		for (Field f : fields) {
			log.info(f.getName() + " --> " + unsafe.objectFieldOffset(f));
		}
		log.info("##############################");
		// arg0, arg1, arg2, arg3 分别是目标对象实例，目标对象属性偏移量，当前预期值，要设的值
		// unsafe.compareAndSwapInt(arg0, arg1, arg2, arg3)
		AnalyzedTarget target = new AnalyzedTarget();
		// 偏移量编译后一般不会变的,intParam这个属性的偏移量
		long intParamOffset = 24;
		// 给它设置,返回true表明设置成功, 基于有名的CAS算法的方法，并发包用这个方法很多
		log.info(""+unsafe.compareAndSwapInt(target, intParamOffset, 0, 3));
		// 比较失败
		log.info(""+unsafe.compareAndSwapInt(target, intParamOffset, 0, 10));
		// 验证下上面是否设置成功,应该还是3，返回ture说明上面没该
		log.info(""+unsafe.compareAndSwapInt(target, intParamOffset, 3, 10));
	}
}
