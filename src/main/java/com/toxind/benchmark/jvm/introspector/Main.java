package com.toxind.benchmark.jvm.introspector;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
//		Map<String, PropertyDescriptor> pds = ClassDescriptorCache.forClass(Person.class).getPropertyDescriptorCache();
//		
//		System.out.println(pds);
		
		Map<String ,Object> val = new HashMap<String, Object>();
		val.put("home", "hangzhou");
		val.put("sex", "female");
		val.put("name", "xxx");
		val.put("age", 123);
		
		Map<String ,Object> xxx1 = new HashMap<String, Object>();
		xxx1.put("home", "xxx1xxx1hangzhou");
		xxx1.put("sex", "xxx1xxx1female");
		xxx1.put("name", "xxx1xxx1abc");
		xxx1.put("age", 223);
		xxx1.put("age1", 223);
		val.put("pxxxx", xxx1);
		
		Person p = BeanUtils.copyPropertiesFromMapToBean(val, Person.class);
		System.out.println(p);
	}
}
