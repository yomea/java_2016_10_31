package com.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater; 

/**
 * 原子更新某个对象的域
 * AtomicIntegerArray
 *  AtomicIntegerFieldUpdater<Y>
 *  AtomicLongArray
 *  详细可见API
 * @author may
 *
 */
public class AtomicIntegerFieldUpdaterDemo { 

   class DemoData{
       public volatile int value1 = 1;//必须是volatile类型的变量
       volatile int value2 = 2;//必须是volatile类型的变量
       protected volatile int value3 = 3;
       private volatile int value4 = 4;
   }
    AtomicIntegerFieldUpdater<DemoData> getUpdater(String fieldName) {
        return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fieldName);
    }
    void doit() {
        DemoData data = new DemoData();
        //System.out.println(data.value4);
        System.out.println("1 ==> "+getUpdater("value1").getAndSet(data, 10));
        System.out.println("3 ==> "+getUpdater("value2").incrementAndGet(data));
        //不太懂为啥，明明AtomicIntegerFieldUpdaterDemo可以访问value4和value3，它却说不能访问
        //Class com.atomic.AtomicIntegerFieldUpdaterDemo can not access a protected member of class com.atomic.AtomicIntegerFieldUpdaterDemo$DemoData using an instance of com.atomic.AtomicIntegerFieldUpdaterDemo$DemoData。
        System.out.println("2 ==> "+getUpdater("value3").decrementAndGet(data));
        System.out.println("true ==> "+getUpdater("value4").compareAndSet(data, 4, 5));
    }
    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
        demo.doit();
    }
} 

