package com.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java.concurrent中的锁机制
 * 
 * @author may
 *
 */
public class AtomicIntegerWithLock {

	private int value;

	private Lock lock = new ReentrantLock();

	public AtomicIntegerWithLock() {
		super();
	}

	public AtomicIntegerWithLock(int value) {
		this.value = value;
	}

	public final int get() {
		lock.lock();
		try {
			return value;
		} finally {
			lock.unlock();
		}
	}

	public final void set(int newValue) {
		lock.lock();
		try {
			value = newValue;
		} finally {
			lock.unlock();
		}

	}

	public final int getAndSet(int newValue) {
		lock.lock();
		try {
			int ret = value;
			value = newValue;
			return ret;
		} finally {
			lock.unlock();
		}
	}

	public final boolean compareAndSet(int expect, int update) {
		lock.lock();
		try {
			if (value == expect) {
				value = update;
				return true;
			}
			return false;
		} finally {
			lock.unlock();
		}
	}

	public final int getAndIncrement() {
		lock.lock();
		try {
			return value++;
		} finally {
			lock.unlock();
		}
	}

	public final int getAndDecrement() {
		lock.lock();
		try {
			return value--;
		} finally {
			lock.unlock();
		}
	}

	public final int incrementAndGet() {
		lock.lock();
		try {
			return ++value;
		} finally {
			lock.unlock();
		}
	}

	public final int decrementAndGet() {
		lock.lock();
		try {
			return --value;
		} finally {
			lock.unlock();
		}
	}

	public String toString() {
		return Integer.toString(get());
	}

	/**
	 * 测试synrchonized与ReetrantLock的性能对比
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		final CountDownLatch startSingnal1 = new CountDownLatch(1); 
		final CountDownLatch startSingnal2 = new CountDownLatch(1); 
		final int max = 10;
		final int loopCount = 100000;
		long costTime = 0;
		for (int m = 0; m < max; m++) {
			long start1 = System.nanoTime();
			final AtomicIntegerWithLock value1 = new AtomicIntegerWithLock(0);
			Thread[] ts = new Thread[max];
			for (int i = 0; i < max; i++) {
				ts[i] = new Thread() {
					public void run() {
						try {
							//等待开始
							startSingnal1.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						for (int i = 0; i < loopCount; i++) {
							value1.incrementAndGet();
						}
					}
				};
			}
			for (Thread t : ts) {
				t.start();
			}
			//所有线程在同一起跑线上开始，闭锁的实现方式
			startSingnal1.countDown();
			for (Thread t : ts) {
				t.join();
			}
			long end1 = System.nanoTime();
			costTime += (end1 - start1);
		}
		System.out.println("lock: " + (costTime));
		//
		System.out.println();
		costTime = 0;
		//
		final Object lock = new Object();
		for (int m = 0; m < max; m++) {
			staticValue = 0;
			long start1 = System.nanoTime();
			Thread[] ts = new Thread[max];
			for (int i = 0; i < max; i++) {
				ts[i] = new Thread() {
					public void run() {
						try {
							startSingnal2.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						for (int i = 0; i < loopCount; i++) {
							synchronized (lock) {
								++staticValue;
							}
						}
					}
				};
			}
			for (Thread t : ts) {
				t.start();
			}
			startSingnal2.countDown();
			for (Thread t : ts) {
				t.join();
			}
			long end1 = System.nanoTime();
			costTime += (end1 - start1);
		}
		//
		System.out.println("synchronized: " + (costTime));
	}

	static int staticValue = 0;
}
