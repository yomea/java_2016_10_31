package com.concurrent;

import java.util.concurrent.SynchronousQueue;

/**
 * 使用SynchronousQueue生产者与消费者
 * 与传统的生产者与消费者的模式最像，生产一个就消费一个
 * @author may
 *
 */
class Produce implements Runnable {
	
	private SynchronousQueue<User> queue = null;
	
	public Produce(SynchronousQueue<User> queue) {
		this.queue = queue;
		
	}

	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			if(i % 2 == 0) {
				
				User user = new User("小红", 21);
				try {
					queue.put(user);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			} else {
				User user = new User("小明", 22);
				try {
					queue.put(user);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
}

class Consumer implements Runnable {

	private SynchronousQueue<User> queue = null;
	
	public Consumer(SynchronousQueue<User> queue) {
		this.queue = queue;
		
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				queue.take().print();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

public class Produce_Consumer_BlockingQueue {
	
	public static void main(String[] args) {
		SynchronousQueue<User> queue = new SynchronousQueue<User>();
		
		
		Produce produce = new Produce(queue);
		
		Consumer consumer = new Consumer(queue);
		
		new Thread(produce).start();
		
		new Thread(consumer).start();
		
	}
	

}
