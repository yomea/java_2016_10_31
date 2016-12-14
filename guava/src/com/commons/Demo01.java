package com.commons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.list.PredicatedList;

/**
 * predicate
 * PredicatedXxx判断集合
 * @author may
 *
 */
public class Demo01 {
	
	public static void main(String[] args) {
		equalPredicate();
		notNullPredicate();
		
		
		
	}
	
	public static void equalPredicate() {
		//判断是否相等
		Predicate<String> pre = EqualPredicate.equalPredicate("youth");
		boolean flag = pre.evaluate("hong");
		System.out.println(flag);
		
	}
	
	public static void notNullPredicate() {
		
		//判断不为空
		Predicate<String> pre = NotNullPredicate.notNullPredicate();
		List<String> list = new ArrayList<String>();
		//PredicatedXxx
		 PredicatedList<String>  predicate = PredicatedList.predicatedList(list, pre);
		 predicate.add(null);//Cannot add Object 'null' - Predicate 'org.apache.commons.collections4.functors.NotNullPredicate@14ae5a5' rejected it
		
		
	}

}
