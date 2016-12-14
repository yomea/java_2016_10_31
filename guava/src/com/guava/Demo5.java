package com.guava;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * 交集、差集、并集
 * @author may
 *
 */
public class Demo5 {
	
	public static void main(String[] args) {
		
		Set<Integer> set1 = Sets.newHashSet(1,2,3,4,5,6);
		
		Set<Integer> set2 = Sets.newHashSet(3,4,5,6,7,8,9);
		
		Set<Integer> set3 = Sets.intersection(set1, set2);
		
		for (Integer integer : set3) {
			System.out.print(integer + " ");
		}
		
		System.out.println();
		
		Set<Integer> set4 = Sets.difference(set1, set2);
		
		for (Integer integer : set4) {
			System.out.print(integer + " ");
		}
		
		System.out.println();
		
		Set<Integer> set5 = Sets.union(set1, set2);
		
		for (Integer integer : set5) {
			System.out.print(integer + " ");
		}
		
		
	}

}
