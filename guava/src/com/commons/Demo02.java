package com.commons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.list.PredicatedList;

/**
 * 自定义predicate
 * 范围约束
 * predicate
 * PredicatedXxx判断集合
 * @author may
 *
 */
public class Demo02 {
	
	public static void main(String[] args) {
		//范围约束
		Predicate<String> predicate = new Predicate<String>() {

			@Override
			public boolean evaluate(String arg0) {
				//这个元素的长度必须在5~20之间
				return arg0.length() > 5 && arg0.length() < 20;
			}
		};
		
		Predicate<String> predicate2 = new Predicate<String>() {

			@Override
			public boolean evaluate(String arg0) {
				//不为空
				return arg0 != null;
			}
		};
		
		List<String> list = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Predicate<String> pre = PredicateUtils.allPredicate(predicate, predicate2);
		
		 PredicatedList<String> preList = PredicatedList.predicatedList(list, pre);
		 
		 preList.add("");// java.lang.IllegalArgumentException
		 preList.add(null);// java.lang.NullPointerException
	}
	
	
	

}
