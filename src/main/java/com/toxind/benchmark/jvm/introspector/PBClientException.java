package com.toxind.benchmark.jvm.introspector;

public class PBClientException extends RuntimeException{

	private static final long serialVersionUID = 3746902337044477586L;
	
	/*
	 * 五位数的ErrorCode：
	 * +10000      --> 1 开头的为客户端异常
	 *   +11000    --> 11000 开头为转换到DTO类的异常
	 *     +11100  --> 11100 说明Map和DTO的字段属性类型不匹配
	 *     +11200  --> 11200 说明Map中的属性在DTO中找不到对应的set方法
	 * +20000  --> 2开头的为服务端异常
	 */
	private int errorCode;
	
	public PBClientException(int errorCode,String errorMsg){
		super(errorMsg);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
