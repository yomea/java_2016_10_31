package com.ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 多个线程可以共享读锁
 * 写锁是独占的
 * 读锁被占用时，写锁不可获取。
 */
public class ReadWriteLockTest {
	
	private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(false);
	
	public static void print() {
		rwLock.readLock().lock();
		
		System.out.println("hello");
		
		while(true) {
			
			
		}
		
		
	}
	
	public static void set() {
		rwLock.writeLock().lock();
		
		System.out.println("set success...");
		
		while(true) {
			
			
		}
		
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		new Thread() {
			
			@Override
			public void run() {
				print();
			}
			
		}.start();
		
		Thread.sleep(1000);
		
		new Thread() {
			
			@Override
			public void run() {
				set();
			}
			
		}.start();
		
	}

}
