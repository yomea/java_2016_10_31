package com.commons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * 集合操作
 * 交集
 * 并集
 * 差集
 * @author may
 *
 */
public class Demo05 {

	public static void main(String[] args) {
		
		Set<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		
		
		Set<Integer> set2 = new HashSet<>();
		
		set2.add(3);
		set2.add(4);
		set2.add(5);
		set2.add(6);
		set2.add(7);
		//交集
		Collection<Integer> intersectionSet = CollectionUtils.intersection(set1, set2);
		
		//差集
		Collection<Integer> subtractSet = CollectionUtils.subtract(set1, set2);
		
		//并集
		Collection<Integer> unionSet = CollectionUtils.union(set1, set2);
		
	}

}
