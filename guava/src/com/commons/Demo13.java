package com.commons;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

/**
 * 
 * Bag 可重复
 * 实现类
 * 		HashBag 无序
 * 		TreeBag 有序
 * @author may
 *
 */
public class Demo13 {

	public static void main(String[] args) {
		
		Bag<String> bag = new HashBag<>();
		
		String words = "She is my girlfriend, she is goodness";
		
		String[] wordArr = words.split(" ");
		
		for (String word : wordArr) {
			bag.add(word);
		}
		
		//获得去重了key值
		Set<String> set = bag.uniqueSet();
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String word = it.next();
			//单词出现的次数
			System.out.println(word + "-->" + bag.getCount(word));
			
		}
		
		
		
	}

}
