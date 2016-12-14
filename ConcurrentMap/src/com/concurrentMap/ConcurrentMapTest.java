package com.concurrentMap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapTest {
	
	//ConcurrentHashMap<K, V>

	/**http://www.blogjava.net/xylz/archive/2010/07/20/326661.html
	 * V putIfAbsent(K key,V value)

		如果不存在key对应的值，则将value以key加入Map，否则返回key对应的旧值。这个等价于清单1 的操作：
		
		清单1 putIfAbsent的等价操作
		
		if (!map.containsKey(key)) 
		   return map.put(key, value);
		else
		   return map.get(key);
	 * 
	 * 
	 * 
	 * boolean remove(Object key,Object value)

		只有目前将键的条目映射到给定值时，才移除该键的条目。这等价于清单3 的操作。
		
		清单3 remove(Object,Object)的等价操作
		
		if (map.containsKey(key) && map.get(key).equals(value)) {
		   map.remove(key);
		   return true;
		}
		return false;
		
		
		
		boolean replace(K key,V oldValue,V newValue)

		只有目前将键的条目映射到给定值时，才替换该键的条目。这等价于清单4 的操作。
		
		清单4 replace(K,V,V)的等价操作
		
		if (map.containsKey(key) && map.get(key).equals(oldValue)) {
		   map.put(key, newValue);
		   return true;
		}
		return false;
		
		 
		
		V replace(K key,V value)
		
		只有当前键存在的时候更新此键对于的值。这等价于清单5 的操作。
		
		清单5 replace(K,V)的等价操作
		
		if (map.containsKey(key)) {
		   return map.put(key, value);
		}
		return null;
		
		replace(K,V,V)相比replace(K,V)而言，就是增加了匹配oldValue的操作。
				
	 */
	
}
