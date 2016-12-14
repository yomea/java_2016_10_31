package com.util;

public class DigitUtil {
	
	//检查是否为整型数字字符串，其实可以使用正则表达式来检验
	public static boolean isIntegerDigit(String numStr) {
		boolean flag = true;
		if(numStr == null || numStr.trim().equals("")) {
			return false;
		}
		//numStr.matches("[0-9]+");
		for(int i = 0; i < numStr.length(); i++) {
			char a = numStr.charAt(i);
			if('0' > a || a > '9') {
				flag = false;
				
			} 
			
		}
		
		return flag;
	}
	//判断numStr是否为数字字符串
	public static boolean isDigit(String numStr) {
		if(numStr == null || numStr.trim().equals("")) {
			return false;
		}
		return numStr.matches("([0-9]+)|([0-9]+\\.[0-9]+)");
	}
	
	public static void main(String[] args) {
		//System.out.println(DigitUtil.isIntegerDigit("1991042"));
		System.out.println(DigitUtil.isDigit("199104.2"));
	}

}
