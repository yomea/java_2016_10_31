package com.format;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;

public class Num {
	
	public static void main(String[] args) {
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
		StringBuffer sb = new StringBuffer("解析后：");
		//创建整数域
		FieldPosition fp = new FieldPosition(NumberFormat.INTEGER_FIELD);
		//得到整数域的第一个数字的位置
		System.out.println(fp.getBeginIndex());
		System.out.println(nf.format(234.346, sb, fp));
		System.out.println(fp.getBeginIndex());
		
	}

}
