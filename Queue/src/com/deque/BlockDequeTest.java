package com.deque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockDequeTest {
	
	public static void main(String[] args) throws Exception {
		
		BlockingDeque<String> deque = new LinkedBlockingDeque<>(2);
		
		//deque.takeFirst();//在双向队列为空时会阻塞
		deque.takeLast();
		
		deque.putLast("d");
		deque.putFirst("a");
		deque.putFirst("b");
		deque.putFirst("c");//在容量满时就会阻塞
		
	}

}
