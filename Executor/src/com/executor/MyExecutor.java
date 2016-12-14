package com.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyExecutor extends ThreadPoolExecutor {

	public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		System.out.println("beforeExecute...");
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		System.out.println("afterExecute...");
	}
	
	

}
