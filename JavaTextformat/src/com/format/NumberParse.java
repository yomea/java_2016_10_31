package com.format;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class NumberParse {
	
	public static void main(String[] args) {
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		ParsePosition parsePosition = new ParsePosition(0);
		
		//之解析整数部分
		numberFormat.setParseIntegerOnly(true);
		Number number = numberFormat.parse("237.234abc", parsePosition);
		
		System.out.println(number.toString());
		
		
	}

}
