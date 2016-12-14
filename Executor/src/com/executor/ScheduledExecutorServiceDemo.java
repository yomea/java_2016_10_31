package com.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {
	public static void main(String[] args) throws Exception {
		ScheduledExecutorService execService = Executors.newScheduledThreadPool(3);
		// 先延时一段时间，之后就不存在这个延时，周期性执行某个任务。、
		/**
		 * 这里的任务会调用线程池中随机的空闲的线程执行
		 * pool-1-thread-2 -> 1481372887943 pool-1-thread-2 -> 1481372889943
		 * pool-1-thread-1 -> 1481372889952 pool-1-thread-3 -> 1481372891943
		 * pool-1-thread-2 -> 1481372892953 pool-1-thread-3 -> 1481372893944
		 * pool-1-thread-3 -> 1481372895944 pool-1-thread-2 -> 1481372895953
		 * pool-1-thread-3 -> 1481372897944 pool-1-thread-2 -> 1481372898955
		 * pool-1-thread-3 -> 1481372899944 pool-1-thread-3 -> 1481372901944
		 * pool-1-thread-2 -> 1481372901956 pool-1-thread-3 -> 1481372903944
		 * pool-1-thread-2 -> 1481372904956 pool-1-thread-3 -> 1481372905944
		 * pool-1-thread-3 -> 1481372907945 pool-1-thread-2 -> 1481372907957
		 * pool-1-thread-3 -> 1481372909946 pool-1-thread-2 -> 1481372910957
		 * 
		 */
		execService.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " -> " + System.currentTimeMillis());
				try {
					Thread.sleep(2000L);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, 1, 1, TimeUnit.SECONDS);
		// 每次执行任务都会存在这个延时
		execService.scheduleWithFixedDelay(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " -> " + System.currentTimeMillis());
				try {
					Thread.sleep(2000L);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, 1, 1, TimeUnit.SECONDS);
		Thread.sleep(1000000000L);
		execService.shutdown();
	}
}