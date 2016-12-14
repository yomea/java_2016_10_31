package com.concurrent;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
	
	public static void main(String[] args) {
		
		
		SynchronousQueue<Integer> sq = new SynchronousQueue<>();
		
		try {
			//sq.take();
			sq.put(2);
			System.out.println(sq.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
