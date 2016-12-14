package com.Semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	
	public static void main(String[] args) throws Exception {
		
		Semaphore semaphore = new Semaphore(1, false);//创建一个不公平的许可,只有一个许可时相当于一个锁
		
		System.out.println(semaphore.availablePermits());//可用许可还剩下有多少个
		
		semaphore.acquire();//获取许可
		
		System.out.println(semaphore.availablePermits());//可用许可还剩下有多少个
		//semaphore.release()释放当前线程占用的许可
		semaphore.acquire();//阻塞，直到semaphore出现一个可用许可时,它是不可重入的，在相同线程获取许可是，计数器递减
		
		
	}

}
