package com.queue.produce_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用BlockingQueue显示生产者与消费者
 * 生产者可以比消费者多生产，甚至满掉，然后阻塞
 * 等待消费者消费，如果没有产品了，那么就等待生产
 * 这种阻塞不会占用锁，跟wait一样，有个叫SynchronousQueue的跟
 * 传统的比较像，生产一个就等待消费者消费掉，才会继续生产。
 * @author may
 *
 */
class Produce implements Runnable {
	
	private BlockingQueue<User> queue = null;
	
	public Produce(BlockingQueue<User> queue) {
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

	private BlockingQueue<User> queue = null;
	
	public Consumer(BlockingQueue<User> queue) {
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
		BlockingQueue<User> queue = new ArrayBlockingQueue<User>(10);
		
		
		Produce produce = new Produce(queue);
		
		Consumer consumer = new Consumer(queue);
		
		new Thread(produce).start();
		
		new Thread(consumer).start();
		
	}
	

}
