package com.ssm.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {
	
	private String datePattern;
	private SimpleDateFormat simpleDateFormat = null;
	
	public DateFormatter(String datePattern) {
		this.datePattern = datePattern;
		
	}

	@Override
	public String print(Date date, Locale locale) {
		simpleDateFormat = new SimpleDateFormat(datePattern);
		String dateStr = simpleDateFormat.format(date);
		return dateStr;
	}

	@Override
	public Date parse(String dateStr, Locale locale) throws ParseException {
		simpleDateFormat = new SimpleDateFormat(datePattern);
		Date date = simpleDateFormat.parse(dateStr);
		return date;
	}


}
