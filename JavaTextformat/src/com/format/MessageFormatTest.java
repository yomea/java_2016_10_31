package com.format;

import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

public class MessageFormatTest {
	
	public static void main(String[] args) {
		
		//下标，格式类型（小写），模式
		String pattern = "my name is {0, date, long}, {0, date, short}, {1}, {2}";
		
		//DateFormat.getDateTimeInstance(DateFormat., timeStyle, aLocale)
		
		DateFormat df = DateFormat.getDateInstance();
		
		MessageFormat mf = new MessageFormat(pattern);
		
		mf.setFormat(0, DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT, Locale.CHINA));//给第一个占位符位置设置格式，当向这个位置设置值得时候按照这个格式去格式化内容
		
		mf.setFormat(1, df);//给第二个占位符位置设置格式，当向这个位置设置值得时候按照这个格式去格式化内容
		
		mf.setFormat(2, df);//给第二个占位符位置设置格式，当向这个位置设置值得时候按照这个格式去格式化内容
		//给pattern按照定义好的格式设置值
		String result = mf.format(new Object[]{new Date(), new Date(), new Date(), new Date()});
		
		System.out.println(MessageFormat.format(pattern, new Date(), "呵呵哒!"));
		
		System.out.println(result);
		
	}

}
