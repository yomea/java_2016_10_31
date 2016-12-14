package com.guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * 使用guava创建不变容器
 * @author may
 *
 */
public class Demo1 {
	
	@SuppressWarnings({ "unused", "deprecation" })
	public static void main(String[] args) {
		
		//jdk创建方式
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		List<String> list2 = Collections.unmodifiableList(list);
		
		//list2.add("d");// java.lang.UnsupportedOperationException
		list.add("d");//a b c d list2会跟着改变
		/*for (String string : list2) {
			System.out.println(string);
		}*/
		
		ImmutableList<String> list3 = ImmutableList.of("a", "b", "c", "d");
		
		list3.add(1, "e");// java.lang.UnsupportedOperationException
		
		
	}

}
