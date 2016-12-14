package com.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	
	
	public static void main(String[] args) throws Exception {
		
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
		
		//BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
		
		queue.put("a");
		queue.put("b");
		//queue.put("c");//超过容量会阻塞，等待空闲的空间
		queue.take();
		queue.take();
		queue.take();
		
	}

}
