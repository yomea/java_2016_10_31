package com.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.iterators.FilterIterator;

/**
 * 过滤迭代
 * @author may
 *
 */
public class Demo09 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("a");
		
		list.add("b");
		
		list.add(null);
		
		list.add(null);
		
		list.add("a");
		
		@SuppressWarnings("unchecked")
		Predicate<String> predicate = NotNullPredicate.INSTANCE;
		
		//过滤迭代器，过滤null值
		Iterator<String> iterator = new FilterIterator<>(list.iterator(), predicate);
		//Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			String value = iterator.next();
			System.out.println(value);
			
		}
	}

}
