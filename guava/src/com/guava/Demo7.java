package com.guava;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * 
 * Multimap; 可重复
 * @author may
 *
 */
public class Demo7 {
	
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		
		map.put("数学", "数学老师");
		map.put("线性代数", "数学老师");
		map.put("语文", "语文老师");
		map.put("物理", "物理老师");
		map.put("英语", "英语老师");
		map.put("化学", "化学老师");
		
		Set<Entry<String, String>> set = map.entrySet();
		
		Multimap<String, String> multimap = ArrayListMultimap.create();
		
		for (Entry<String, String> entry : set) {
			String key = entry.getKey();
			String value = entry.getValue();
			multimap.put(value, key);
			
		}
		
		Set<String> set2 = multimap.keySet();
		
		for (String string : set2) {
			Collection<String> collection = multimap.get(string);
			System.out.println(string + "-->" + collection);
		}
		
		
	}

}
