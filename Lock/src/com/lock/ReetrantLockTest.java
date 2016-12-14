package com.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Value {
	
	private Lock lock = null;
	
	public Value(Lock lock) {
		this.lock = lock;
		
	}
	
	private int count;
	
	public void increment() {
		//尝试获得锁，如果获得到就返回TRUE，获取不到返回FALSE
		boolean flag = lock.tryLock();
		System.out.println(flag);
		/*try {
			lock.lockInterruptibly();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		try {
			count ++;
			System.out.println(count);
			
		} finally {
			//没有获得锁的线程调用次方法将报错
			lock.unlock();
		}
	}
	
	public void decrement() {
		
		lock.lock();
		try {
			count --;
			
		} finally {
			lock.unlock();
		}
	}
	
	
}

public class ReetrantLockTest implements Runnable {
	
	private static ReentrantLock lock = new ReentrantLock();
	
	private Value value = null;
	
	public ReetrantLockTest(Value value) {
		this.value = value;
		
	}
	
	
	public static void main(String[] args) {
		
		Value value = new Value(lock);
		
		new Thread(new ReetrantLockTest(value)).start();
		new Thread(new ReetrantLockTest(value)).start();
		
	}


	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			
			value.increment();
			
		}
		
	}

}
