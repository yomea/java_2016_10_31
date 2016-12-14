package com.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

	/**
	 * 线程池在构造前（new操作）是初始状态，一旦构造完成线程池就进入了执行状态RUNNING。严格意义上讲线程池构造完成后并没有线程被立即启动，只有进行“预启动”或者接收到任务的时候才会启动线程。这个会后面线程池的原理会详细分析。但是线程池是出于运行状态，随时准备接受任务来执行。
	 * 线程池运行中可以通过shutdown()和shutdownNow()来改变运行状态。shutdown()是一个平缓的关闭过程，线程池停止接受新的任务，同时等待已经提交的任务执行完毕，包括那些进入队列还没有开始的任务，这时候线程池处于SHUTDOWN状态；shutdownNow()是一个立即关闭过程，线程池停止接受新的任务，同时线程池取消所有执行的任务和已经进入队列但是还没有执行的任务，这时候线程池处于STOP状态。
	 * 一旦shutdown()或者shutdownNow()执行完毕，线程池就进入TERMINATED状态，此时线程池就结束了。
	 * isTerminating()描述的是SHUTDOWN和STOP两种状态。
	 * isShutdown()描述的是非RUNNING状态，也就是SHUTDOWN/STOP/TERMINATED三种状态
	 */

	public static void main(String[] args) {
		//Executors
		// Executor
		// ExecutorService
		// ThreadPoolExecutor
		// ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,
		// maximumPoolSize, keepAliveTime, unit, workQueue)
		
		/**
		 * 强烈建议程序员使用较为方便的 Executors 工厂方法
		 * Executors.newCachedThreadPool()（无界线程池，可以进行自动线程回收）、Executors.newFixedThreadPool(int)（固定大小线程池）和
		 * Executors.newSingleThreadExecutor()（单个后台线程），它们均为大多数使用场景预定义了设置。”
		 */
		MyExecutor executor = new MyExecutor(1, 2, 1, TimeUnit.DAYS,
				new ArrayBlockingQueue<Runnable>(5));
		
		//设置拒绝执行策略
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
		// executor.submit()
		for (int i = 0; i < 10; i++) {
			final int num = i;
			//每new出来的Runnable都是一个任务，但提交任务后，线程池会根据情况创建worker线程去执行任务。
			//创建出来的worker线程按照KeepAlivetime来作为他的生命时间，未到时间就不会销毁，一直存在线程池中,这样可以
			//增加线程的利用率，一般如果一个工作线程执行时间比较短的话，可以继续让它存活更长的时间，准备下次执行任务，这样可以减小创建线程的开销。

			//Executors.newCachedThreadPool()//创建一个无边界的线程池
			//Executors.newSingleThreadExecutor()//创建一个包含一个工作线程的线程池
			//Executors.newFixedThreadPool(nThreads)//创建一个固定大小的线程池
			
			executor.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println("hello world!-->" + num);
				}

			});
		}
		executor.shutdown();
		
	}

}
