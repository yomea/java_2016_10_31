package com.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.iterators.LoopingIterator;

/**
 * 循环迭代
 * @author may
 *
 */
public class Demo10 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("a");
		
		list.add("b");
		
		
		list.add("c");
		
		Iterator<String> iterator = new LoopingIterator<String>(list);
		
		/**
		 * 循环打印
		 */
		
		for(int i = 0; i < 30; i++) {
			String value = iterator.next();
			System.out.println(value);
			
		}
	}

}
