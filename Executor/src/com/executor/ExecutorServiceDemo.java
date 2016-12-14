package com.executor;

import java.lang.reflect.Field;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 参考资料地址：http://www.infoq.com/cn/articles/java-threadPool/
 * 
 * corePoolSize（线程池的基本大小）：当提交一个任务到线程池时，线程池会创建一个线程来执行任务，即使其他空闲的基本线程能够执行新任务也会创建线程，等到需要执行的任务数大于线程池基本大小时就不再创建。如果调用了线程池的prestartAllCoreThreads方法，线程池会提前创建并启动所有基本线程。
 * runnableTaskQueue（任务队列）：用于保存等待执行的任务的阻塞队列。 可以选择以下几个阻塞队列。
 * ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按 FIFO（先进先出）原则对元素进行排序。
 * LinkedBlockingQueue：一个基于链表结构的阻塞队列，此队列按FIFO （先进先出）
 * 排序元素，吞吐量通常要高于ArrayBlockingQueue。静态工厂方法Executors.newFixedThreadPool()使用了这个队列。
 * SynchronousQueue：一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue，静态工厂方法Executors.newCachedThreadPool使用了这个队列。
 * PriorityBlockingQueue：一个具有优先级的无限阻塞队列。
 * maximumPoolSize（线程池最大大小）：线程池允许创建的最大线程数。如果队列满了，并且已创建的线程数小于最大线程数，则线程池会再创建新的线程执行任务。值得注意的是如果使用了无界的任务队列这个参数就没什么效果。
 * ThreadFactory：用于设置创建线程的工厂，可以通过线程工厂给每个创建出来的线程设置更有意义的名字。
 * RejectedExecutionHandler（饱和策略）：当队列和线程池都满了，说明线程池处于饱和状态，那么必须采取一种策略处理提交的新任务。这个策略默认情况下是AbortPolicy，表示无法处理新任务时抛出异常。以下是JDK1.5提供的四种策略。
 * AbortPolicy：直接抛出异常。 CallerRunsPolicy：只用调用者所在线程来运行任务。
 * DiscardOldestPolicy：丢弃队列里最近的一个任务，并执行当前任务。 DiscardPolicy：不处理，丢弃掉。
 * 当然也可以根据应用场景需要来实现RejectedExecutionHandler接口自定义策略。如记录日志或持久化不能处理的任务。
 * keepAliveTime（线程活动保持时间）：线程池的工作线程空闲后，保持存活的时间。所以如果任务很多，并且每个任务执行的时间比较短，可以调大这个时间，提高线程的利用率。
 * TimeUnit（线程活动保持时间的单位）：可选的单位有天（DAYS），小时（HOURS），分钟（MINUTES），毫秒(MILLISECONDS)，微秒(MICROSECONDS,
 * 千分之一毫秒)和毫微秒(NANOSECONDS, 千分之一微秒)。
 * 
 * 我们可以使用execute提交的任务，但是execute方法没有返回值，所以无法判断任务是否被线程池执行成功。通过以下代码可知execute方法输入的任务是一个Runnable类的实例。
 * threadsPool.execute(new Runnable() {
 * 
 * @Override public void run() { // TODO Auto-generated method stub } });
 *           我们也可以使用submit
 *           方法来提交任务，它会返回一个future,那么我们可以通过这个future来判断任务是否执行成功，通过future的get方法来获取返回值，get方法会阻塞住直到任务完成，而使用get(long
 *           timeout, TimeUnit unit)方法则会阻塞一段时间后立即返回，这时有可能任务没有执行完。 Future<Object>
 *           future = executor.submit(harReturnValuetask); try { Object s =
 *           future.get(); } catch (InterruptedException e) { // 处理中断异常 } catch
 *           (ExecutionException e) { // 处理无法执行任务异常 } finally { // 关闭线程池
 *           executor.shutdown(); } 线程池的关闭
 *           我们可以通过调用线程池的shutdown或shutdownNow方法来关闭线程池，它们的原理是遍历线程池中的工作线程，然后逐个调用线程的interrupt方法来中断线程，所以无法响应中断的任务可能永远无法终止。但是它们存在一定的区别，shutdownNow首先将线程池的状态设置成STOP，然后尝试停止所有的正在执行或暂停任务的线程，并返回等待执行任务的列表，而shutdown只是将线程池的状态设置成SHUTDOWN状态，然后中断所有没有正在执行任务的线程。
 *           只要调用了这两个关闭方法的其中一个，isShutdown方法就会返回true。当所有的任务都已关闭后,才表示线程池关闭成功，这时调用isTerminaed方法会返回true。至于我们应该调用哪一种方法来关闭线程池，应该由提交到线程池的任务特性决定，通常调用shutdown来关闭线程池，如果任务不一定要执行完，则可以调用shutdownNow
 * 
 * 
 * @author may
 *
 */
public class ExecutorServiceDemo {

	static void log(String msg) {
		System.out.println(System.currentTimeMillis() + " -> " + msg);
	}

	static int getThreadPoolRunState(ThreadPoolExecutor pool) throws Exception {
		Field f = ThreadPoolExecutor.class.getDeclaredField("runState");
		f.setAccessible(true);
		int v = f.getInt(pool);
		return v;
	}

	public static void main(String[] args) throws Exception {
		
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(1));
		pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

		for (int i = 0; i < 10; i++) {
			final int index = i;
			pool.submit(new Runnable() {

				public void run() {
					log("run task:" + index + " -> " + Thread.currentThread().getName());
					try {
						Thread.sleep(1000L);
					} catch (Exception e) {
						e.printStackTrace();
					}
					log("run over:" + index + " -> " + Thread.currentThread().getName());
				}
			});
		}
		System.out.println(pool.getPoolSize());
		log("before sleep");
		Thread.sleep(4000L);
		log("before shutdown()");
		pool.shutdown();
		log("after shutdown(),pool.isTerminated=" + pool.isTerminated());
		pool.awaitTermination(1000L, TimeUnit.SECONDS);
		log("now,pool.isTerminated=" + pool.isTerminated() + ", state=" + getThreadPoolRunState(pool));
	}

}
