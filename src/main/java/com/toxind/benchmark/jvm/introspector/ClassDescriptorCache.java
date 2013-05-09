package com.toxind.benchmark.jvm.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@SuppressWarnings("rawtypes")
public class ClassDescriptorCache {

	
	private final static Map<Class,ClassDescriptorCache> classCache = new WeakHashMap<Class,ClassDescriptorCache>();
	
	private static ReadWriteLock lock = new ReentrantReadWriteLock();
	
	private BeanInfo beanInfo;
		
	private Map<String , Method> methodCache ;

	private ClassDescriptorCache(Class beanClass){
		try {
			this.beanInfo = Introspector.getBeanInfo(beanClass);
			
			this.methodCache = new HashMap<String, Method>();

			PropertyDescriptor[] pds = this.beanInfo.getPropertyDescriptors();
			for (int i = 0; i < pds.length; i++) {
				PropertyDescriptor pd = pds[i];
				Method writeMethod = pd.getWriteMethod();
				if(writeMethod != null){
					if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
						writeMethod.setAccessible(true);
					}
					this.methodCache.put(pd.getName(), writeMethod);
				}
			}
		} 
		catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}
	
	public static ClassDescriptorCache forClass(Class clazz){

		lock.readLock().lock();
		try{			
			ClassDescriptorCache cache = classCache.get(clazz);
			if(cache == null){
				lock.readLock().unlock();
				lock.writeLock().lock();
				try{
					cache = classCache.get(clazz);
					if(cache == null){
						cache = new ClassDescriptorCache(clazz);
						classCache.put(clazz, cache);
					}
				}finally{
					lock.readLock().lock();
					lock.writeLock().unlock();
				}

			}
			return cache;
			
		}finally{
			lock.readLock().unlock();
		}

	}

	public Map<String, Method> getMethodCache() {
		return methodCache;
	}

}
