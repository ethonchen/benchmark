package com.toxind.benchmark.jvm.introspector;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

public class BeanUtils {

	public static <T> T copyPropertiesFromMapToBean(Map<String, Object> source,
			Class<T> target) {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");
		T tarObj = instantiate(target);

		Map<String, Method> methodCache = ClassDescriptorCache.forClass(target)
				.getMethodCache();

		for (Entry<String, Object> entry : source.entrySet()) {
			if (entry.getValue() instanceof Map) {
				@SuppressWarnings("unchecked")
				Map<String, Object> subMap = (Map<String, Object>) entry.getValue();
				Method writeMethod = methodCache.get(entry.getKey());
				if (writeMethod != null) {
					Class<?>[] params = writeMethod.getParameterTypes();
					if (params.length != 1) {
						throw new IllegalArgumentException(target.toString() + " "
								+ writeMethod.getName()
								+ " 's param should only one class!");
					}
					Object o = copyPropertiesFromMapToBean(subMap, params[0]);
					entry.setValue(o);
				} else {
					throwMapTooManyAttException(target, entry.getKey());
				}
			}
			Method writeMethod = methodCache.get(entry.getKey());
			if (writeMethod != null) {
				try {
					writeMethod.invoke(tarObj, entry.getValue());
				} catch (IllegalArgumentException e) {
					throwAttributeNotMatchException(target, entry.getValue(), writeMethod);
				} catch (InvocationTargetException e) {
					throw new IllegalArgumentException(e.getMessage());
				} catch (IllegalAccessException e) {
					throw new IllegalArgumentException(e.getMessage());
				}
			} else {
				throwMapTooManyAttException(target, entry.getKey());
			}

		}

		return tarObj;
	}

	private static <T> void throwAttributeNotMatchException(Class<T> target,
			Object mapValue, Method writeMethod) {
		StringBuilder errorMsg = new StringBuilder();
		errorMsg.append("the params not match ! [")
				.append(target.toString())
				.append(" : ")
				.append(writeMethod.getName())
				.append("] needs ")
				.append(Arrays.toString(writeMethod
						.getParameterTypes()))
				.append(" but the server gives a [")
				.append(mapValue == null ? "null" : mapValue.getClass().toString())
				.append("]");

		throw new PBClientException(11100, errorMsg.toString());
	}

	private static <T> void throwMapTooManyAttException(Class<T> target,
			String mapKey) {
		StringBuilder errorMsg = new StringBuilder();
		errorMsg.append("the pql's request contains the attribute [")
				.append(mapKey).append("] but [")
				.append(target.toString())
				.append("] do not have this set method.")
				.append(" you should adjust your pql to reduce the return content");
		throw new PBClientException(11200, errorMsg.toString());
	}

	public static <T> T instantiate(Class<T> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		if (clazz.isInterface()) {
			throw new IllegalAccessError(clazz
					+ " Specified class is an interface");
		}
		try {
			return clazz.newInstance();
		} catch (InstantiationException ex) {
			throw new IllegalAccessError(clazz + " Is it an abstract class?");
		} catch (IllegalAccessException e) {
			throw new IllegalAccessError(clazz + " IllegalAccessException ");
		}
	}
}
