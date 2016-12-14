package com.commons;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

/**
 * 双向的map
 * BidiMap 键值不能重复
 * 实现类：
 * 	DualTreeBidiMap 有序
 * DualHashBidiMap 无序
 * @author may
 *
 */
public class Demo12 {

	public static void main(String[] args) {
		
		BidiMap<String, String> bidiMap = new DualHashBidiMap<>();//无序
		//BidiMap<String, String> bidiMap = new DualTreeBidiMap<>();//有序
		
		bidiMap.put("a", "aaa");
		bidiMap.put("b", "bbb");
		bidiMap.put("c", "ccc");
		//反转
		MapIterator<String, String> it = bidiMap.inverseBidiMap().mapIterator();
		
		for(;it.hasNext();) {
			String key = it.next();
			String value = it.getValue();
			
			System.out.println(key + "-->" + value);
			
		}
		
		
	}

}
