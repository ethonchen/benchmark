package com.toxind.benchmark.jvm.thread;

public class InterruptHelper {
	
	public InterruptHelper(Thread parentThread,RuntimeException exception){
		this.parentThread = parentThread;
		this.exception = exception;
	}
	
	private Thread parentThread;
	
	private RuntimeException exception;

	public Thread getParentThread() {
		return parentThread;
	}

	public void setParentThread(Thread parentThread) {
		this.parentThread = parentThread;
	}

	public RuntimeException getException() {
		return exception;
	}

	public void setException(RuntimeException exception) {
		this.exception = exception;
	}


	
	

}
