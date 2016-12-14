package com.commons;

import java.util.Iterator;

import org.apache.commons.collections4.iterators.ArrayIterator;

/**
 * 数组迭代
 * @author may
 *
 */
public class Demo11 {

	public static void main(String[] args) {
		
		int[] arr = new int[]{1,2,3,4,5,56,6,7,8};
		
		Iterator<Integer> iterator = new ArrayIterator<>(arr);
		
		for(;iterator.hasNext();) {
			int a = iterator.next();
			
			System.out.println(a);
			
		}
		
	}

}
