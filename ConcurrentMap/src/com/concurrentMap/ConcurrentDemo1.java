package com.concurrentMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 使用ConcurrentMap实现的单例模式
 * @author may
 *
 */
public class ConcurrentDemo1 {

    private static final ConcurrentMap<String, ConcurrentDemo1> map = new ConcurrentHashMap<String, ConcurrentDemo1>();
    private static ConcurrentDemo1 instance;
    public static ConcurrentDemo1 getInstance() {
        if (instance == null) {
        	//V putIfAbsent(K,V)如果键值k存在，那么直接返回旧值，如果不存在，就将值放进去。
        	/**
        	 * 等价于
        	 * if (!map.containsKey(key)) 
				   return map.put(key, value);
				else
				   return map.get(key);
        	 */
            map.putIfAbsent("INSTANCE", new ConcurrentDemo1());

            instance = map.get("INSTANCE");
        }
        return instance;
    }

    private ConcurrentDemo1() {
    }

}
