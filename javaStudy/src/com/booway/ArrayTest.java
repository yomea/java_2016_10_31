package com.booway;

import java.lang.reflect.Array;

public class ArrayTest {
	
	public static void main(String[] args) {
		
		Integer[] ints = new Integer[3];
		
		ints[0] = 1;
		ints[1] = 2;
		ints[2] = 3;
		
		Object obj = Array.newInstance(String.class, 3);//根据传入的类型，创建一个长度为3的数组
		
		Array.newInstance(String.class, 5,3);//创建一个5行3列的二维数组
		
		String[] strs = (String[])obj;
		
		strs[0] = "a";
		strs[1] = "b";
		strs[2] = "c";
		
		for(int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
			
		}
		
		
		System.out.println(Array.get(ints, 2));
		
		int[] ints3 = new int[3];
		
		ints3[0] = 345;
		
		Array.setInt(ints3, 1, 23);
		
		Array.setInt(ints3, 2, 35);
		
		
		
		System.out.println(Array.getInt(ints3, 0));//从指定的整型数组中取出指定位置的整数
		System.out.println(Array.getInt(ints3, 2));//从指定的整型数组中取出指定位置的整数
	}

}
