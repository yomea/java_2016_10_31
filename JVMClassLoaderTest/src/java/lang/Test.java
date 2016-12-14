package java.lang;

import java.lang.String;
import java.lang.System;

public class Test {
	
	public static void main(String[] args) {
		
		String str = "test";//java.lang.SecurityException: Prohibited package name: java.lang
		
		System.out.println(str.getClass().getClassLoader());
		
		System.out.println(str.toString());
		
		
	}

}
