package com.commons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 * 
 * 队列操作
 * 
 * @author may
 *
 */
public class Demo06 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		CircularFifoQueue<String> circularFifoQueue = new CircularFifoQueue<>(2);
		
		circularFifoQueue.add("a");
		
		circularFifoQueue.add("b");
		
		circularFifoQueue.add("c");//加入这个，a会被挤出
		
		Queue<String> unmodifiableQueue = UnmodifiableQueue.unmodifiableQueue(circularFifoQueue);
		
		unmodifiableQueue.add("");//java.lang.UnsupportedOperationException
		for(int i = 0; i < circularFifoQueue.size(); i++) {
			System.out.println(circularFifoQueue.get(i));
			
		}
		
		 PredicatedQueue<String> predicateQueue = PredicatedQueue.predicatedQueue(circularFifoQueue, NotNullPredicate.INSTANCE);
		
		 predicateQueue.add(null);//java.lang.IllegalArgumentException
		 
	}

}
