package com.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.iterators.UniqueFilterIterator;

/**
 * 去重迭代
 * @author may
 *
 */
public class Demo08 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("a");
		
		list.add("b");
		
		list.add("a");
		//去掉重复的值，存到新的集合中，然后返回这个新的集合的iterator.
		Iterator<String> iterator = new UniqueFilterIterator<>(list.iterator());
		
		while(iterator.hasNext()) {
			String value = iterator.next();
			System.out.println(value);
			
		}
	}

}
