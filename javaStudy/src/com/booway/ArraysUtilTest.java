package com.booway;

import java.util.Arrays;
import java.util.List;

public class ArraysUtilTest {
	
	public static void main(String[] args) {
		
		List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7);
		
		String[] strings = new String[3];
		
		strings[0] = "a";
		strings[2] = "c";
		strings[1] = "b";
		
		List<String> strs = Arrays.asList(strings);
		
		for (Integer integer : ints) {
			System.out.println(integer);
		}
		
		for (String string : strs) {
			System.out.println(string);
		}
		//复制指定长度的内容，如果超过则用null，或者0代替
		String[] arrStr = Arrays.copyOf(strings, strings.length-1);
		//抛出异常 java.lang.ArrayIndexOutOfBoundsException: 2
		//System.out.println("Arrays.copyOf-->"+arrStr[2]);
		
		Object[] obj = new Object[2];
		
		obj[0] = "hello";
		
		obj[1] = "world";
		//将obj转换成指定的数据类型的数组
		String[] arrStr2 = Arrays.copyOf(obj, obj.length, String[].class);
		
		System.out.println(arrStr2[1]);
		
		//使用二分法查找指定元素，返回下标，如果没有返回负数；
		System.out.println(Arrays.binarySearch(strings, 0, strings.length, "8", null));
		
		
		int[] ints2 = new int[]{1,2};
		
		//指定范围copy
		Arrays.copyOfRange(ints2, 0, ints2.length);
		//用a填充数组
		Arrays.fill(new Object[3], "a");
		
		System.out.println(Arrays.deepToString(new Object[]{"sd","sc"}));
		
	}

}
