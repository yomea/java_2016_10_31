package com.produceAndConsume;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 使用Condition来左移生产者和消费者
 * @author may
 *
 * @param <T>
 */
public class ProductQueue<T> {

    private final T[] items;

    private final Lock lock = new ReentrantLock();
    //创建一个没有装满篮子的条件
    private Condition notFull = lock.newCondition();
    //创建一个篮子不为空的条件
    private Condition notEmpty = lock.newCondition();

    //
    private int head, tail, count;

    public ProductQueue(int maxSize) {
        items = (T[]) new Object[maxSize];
    }

    public ProductQueue() {
        this(10);
    }

    public void put(T t) throws InterruptedException {
    	//使用独占锁
        lock.lock();
        try {
            while (count == getCapacity()) {
            	 //notFull休眠线程
                notFull.await();
            }
            items[tail] = t;
            if (++tail == getCapacity()) {
                tail = 0;
            }
            ++count;
            //唤醒被notEmpty休眠的线程
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
            	//使用notEmpty休眠线程
                notEmpty.await();
            }
            T ret = items[head];
            items[head] = null;//GC
            //
            if (++head == getCapacity()) {
                head = 0;
            }
            --count;
            //唤醒被notFull await的线程
            notFull.signalAll();
            return ret;
        } finally {
            lock.unlock();
        }
    }

    public int getCapacity() {
        return items.length;
    }

    public int size() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

}