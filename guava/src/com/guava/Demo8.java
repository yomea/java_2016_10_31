package com.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * 
 * Bimap;键值不可重复
 * @author may
 *
 */
public class Demo8 {
	
	public static void main(String[] args) {
		
		BiMap<String, String> biMap = HashBiMap.create();
		
		biMap.put("a", "a");
		biMap.put("a", "a");//重复的不算
		//biMap.put("b", "a");// 如果只是值重复，直接出错java.lang.IllegalArgumentException: value already present: a
		biMap.put("a", "b");//重复的不算
		
		String b = biMap.inverse().get("b");
		
		System.out.println(b);
		
		
		System.out.println(biMap.size());
		
	}

}
