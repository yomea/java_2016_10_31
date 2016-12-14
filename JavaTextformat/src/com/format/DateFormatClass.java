package com.format;

import java.text.DateFormat;
import java.util.Date;

public class DateFormatClass {  
	  
    public static void main(String[] args) {  
        DateFormatClass.date_Format();  
    }  
    public static void date_Format() {  
        System.out.println("使用DateFormat类获取系统的当前时间的示例如下所示：");  
        Date date = new Date();  
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(  
                DateFormat.SHORT, DateFormat.SHORT);  
        DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(  
                DateFormat.MEDIUM, DateFormat.MEDIUM);  
        DateFormat longDateFormat = DateFormat.getDateTimeInstance(  
                DateFormat.LONG, DateFormat.LONG);  
        DateFormat fullDateFormat = DateFormat.getDateTimeInstance(  
                DateFormat.FULL, DateFormat.FULL);  
        System.out.println("SHORT 模式的日期为：" + shortDateFormat.format(date));  
        System.out.println("MEDIUM 模式的日期为：" + mediumDateFormat.format(date));  
        System.out.println("LONG 模式的日期为：" + longDateFormat.format(date));  
        System.out.println("FULL 模式的日期为：" + fullDateFormat.format(date));  
    }  
  
}  
