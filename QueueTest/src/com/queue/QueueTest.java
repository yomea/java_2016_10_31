package com.queue;

public class QueueTest {

	/**
	 * 如果不需要阻塞队列，优先选择ConcurrentLinkedQueue；
	 * 如果需要阻塞队列，队列大小固定优先选择ArrayBlockingQueue，
	 * 队列大小不固定优先选择LinkedBlockingQueue；如果需要对队列进行排序，
	 * 选择PriorityBlockingQueue；如果需要一个快速交换的队列，选择SynchronousQueue；
	 * 如果需要对队列中的元素进行延时操作，则选择DelayQueue。
	 */

}
