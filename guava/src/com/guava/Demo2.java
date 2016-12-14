package com.guava;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
/**
 * guava创建list
 * Predicate
 * function
 */
import com.google.common.collect.Lists;

public class Demo2 {
	
	public static void main(String[] args) {
		
		List<String> list = Lists.newArrayList("moom", "son", "dad", "sos");
		
		/**
		 * 过滤回文
		 */
		Collection<String> collection = Collections2.filter(list, new Predicate<String>() {

			@Override
			public boolean apply(String input) {
				
				return new StringBuilder(input).reverse().toString().equals(input);
			}
		});
		
		
		for (String string : collection) {
			System.out.println(string);
		}
		
		
		
		
	}

}
