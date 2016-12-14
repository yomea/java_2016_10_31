package com.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * 统计单词
 * Multiset:无序+可重复 .count()
 * @author may
 *
 */
public class Demo6 {
	
	public static void main(String[] args) {
		
		String words = "my name is youth, you name is hong";
		
		String[] wordArr = words.split(" ");
		
		Multiset<String> set = HashMultiset.create();
		
		for (String word : wordArr) {
			set.add(word);
		}
		
		for (String string : set) {
			//统计单词出现的次数
			System.out.println(string + "-->" + set.count(string));
		}
		
	}

}
