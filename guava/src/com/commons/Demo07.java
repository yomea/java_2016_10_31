package com.commons;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.HashedMap;

/**
 * 可迭代map
 * @author may
 *
 */
public class Demo07 {

	public static void main(String[] args) {
		IterableMap<String, String> map = new HashedMap<>();
		
		map.put("a", "a");
		map.put("b", "b");
		map.put("c", "c");
		map.put("d", "d");
		
		MapIterator<String, String> mapIterator = map.mapIterator();
		
		while(mapIterator.hasNext()) {
			String key = mapIterator.next();
			String value = mapIterator.getValue();
			
			System.out.println(key + "-->" + value);
			
		}
		 
	}

}
