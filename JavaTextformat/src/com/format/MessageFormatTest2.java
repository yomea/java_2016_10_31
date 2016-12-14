package com.format;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class MessageFormatTest2 {
	
	public static void main(String[] args) throws ParseException {
		
		String pattern = "At {0} on {1}, {2} destroyed {3} houses and caused {4} of damage.";
		
		MessageFormat mf = new MessageFormat(pattern);
		
		String datetimeString = "Jul 3, 1998 12:30 PM";
		
		Date date = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT, Locale.US).parse(datetimeString);
		
		String event = "a hurricance";
		
		Object[] magArgs = {date, date, event, new Integer(99), new Double(1e7)};
		//给对应下标设置格式。
		mf.setFormatByArgumentIndex(0, DateFormat.getTimeInstance(DateFormat.SHORT));
		
		mf.setFormatByArgumentIndex(1, DateFormat.getDateInstance());
		
		mf.setFormatByArgumentIndex(4, NumberFormat.getCurrencyInstance());
		
		String result = mf.format(magArgs);
		
		System.out.println(result);
		
		
	}

}
