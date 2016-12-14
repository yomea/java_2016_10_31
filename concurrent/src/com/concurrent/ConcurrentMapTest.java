package com.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentMapTest {

	public static void main(String[] args) {

		ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

		map.put("a", 12);
		map.put("b", 13);

		// 使得map成为线程安全的
		Map<String, Integer> map2 = Collections.synchronizedMap(new HashMap<String, Integer>());

		// 原子性AtomicReference<Integer> atomicReference = new
		// AtomicReference<Integer>();

		// CopyOnWriteArrayList<E>每次进行改变都会使用原形模式，克隆一份放回
		// CopyOnWriteArraySet<E>

		System.out.println(map.get("b"));

	}

}
