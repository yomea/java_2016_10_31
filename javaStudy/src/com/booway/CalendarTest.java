package com.booway;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CalendarTest {
	
	public static void main(String[] args) {
		
		GregorianCalendar calendar = new GregorianCalendar();
		
		System.out.println(calendar.get(Calendar.YEAR));
		
		Date date = new Date();
		
		Calendar cl = Calendar.getInstance();
		
		cl.setTime(date);
		
		System.out.println(cl.get(cl.getMaximum(Calendar.MONTH)));
		
		System.out.println(cl.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		System.out.println(cl.getDisplayName(Calendar.AM, DateFormat.MEDIUM, Locale.CHINA));
	}

}
