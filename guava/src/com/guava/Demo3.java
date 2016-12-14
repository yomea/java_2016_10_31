package com.guava;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
/**
 * Collections2函数式编程
 * @author may
 *
 */
public class Demo3 {
	
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
		
		//转换成大写
		Function<String, String> function1 = new Function<String, String>() {

			@Override
			public String apply(String input) {
				
				return input.toUpperCase();
			}
		};
		//截取字符
		Function<String, String> function2 = new Function<String, String>() {

			@Override
			public String apply(String input) {
				
				if(input.length() > 3) {
					
					return input.substring(2);
					
				}
				return input;
				
			}
		};
		
		//组合函数
		Function<String, String> function = Functions.compose(function1, function2);
		
		Collection<String> collection2 = Collections2.transform(collection, function);
		
		
		
		for (String string : collection) {
			System.out.println(string);
		}
		
		for (String string : collection2) {
			System.out.println(string);
		}
		
		
		
	}

}
