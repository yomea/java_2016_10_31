package com.commons;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.SwitchTransformer;

/**
 * 自定义predicate
 * 和transform联合使用
 * SwitchTransformer
 * @author may
 *
 */
public class Demo03 {

	public static void main(String[] args) {
		// 范围约束
		Predicate<Long> predicate = new Predicate<Long>() {

			@Override
			public boolean evaluate(Long arg0) {
				// 这个元素小于10000
				return arg0 < 10000L;
			}
		};

		Predicate<Long> predicate2 = new Predicate<Long>() {

			@Override
			public boolean evaluate(Long arg0) {
			
				return arg0 >= 10000L;
			}
		};
		//判断组
		Predicate[] predicates = {predicate, predicate2};
		//将long值转化成string
		Transformer<Long, String> transform = new Transformer<Long, String>() {

			@Override
			public String transform(Long arg0) {
				
				return new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒").format(arg0);
			}
		};
		
		Transformer<Long, String> transform2 = new Transformer<Long, String>() {

			@Override
			public String transform(Long arg0) {
				
				return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(arg0);
			}
		};
		
		List<Long> list = new ArrayList<>();
		
		list.add(15000L);
		
		list.add(10000L);
		
		list.add(9000L);
		
		//list.add(1000L);// java.lang.ArrayIndexOutOfBoundsException
		
		//list.add(null);// java.lang.ArrayIndexOutOfBoundsException
		//类型转换组
		Transformer[] transformers = {transform, transform2};
		
		Transformer<Long, String> trans = new SwitchTransformer<>(predicates, transformers, null);
		
		Collection<String> collection = CollectionUtils.collect(list, trans);
		
		for (String string : collection) {
			System.out.println(string);
		}

	}

}
