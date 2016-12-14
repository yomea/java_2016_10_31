package com.atomic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

/**
 * AtomicInteger和AtomicLong、AtomicBoolean、AtomicReference差不多
 * @author may
 *
 */
public class AtomicTest {

    @Test
    public void testAll() throws InterruptedException{
        final AtomicInteger value = new AtomicInteger(10);
       /*boolean compareAndSet(int expect, int update)
        如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。 如果成功就返回true，否则返回false，并且不修改原值。*/
        assertEquals(value.compareAndSet(1, 2), false);
        assertEquals(value.get(), 10);
        assertTrue(value.compareAndSet(10, 3));
        assertEquals(value.get(), 3);
        value.set(0);
        //先原子递增然后返回该改变的值
        assertEquals(value.incrementAndGet(), 1);
        //getAndAdd(int delta)先得到旧值，然后递增delta
        assertEquals(value.getAndAdd(2),1);
        assertEquals(value.getAndSet(5),3);
        assertEquals(value.get(),5);
        //
        final int threadSize = 10;
        Thread[] ts = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            ts[i] = new Thread() {
                public void run() {
                    value.incrementAndGet();
                }
            };
        }
        //
        for(Thread t:ts) {
            t.start();
        }
        for(Thread t:ts) {
            t.join();
        }
        //最后查看值是否为15，如果是，说明是线程安全的。
        assertEquals(value.get(), 5+threadSize);
    }

}