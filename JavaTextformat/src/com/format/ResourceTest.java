package com.format;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceTest {
	
	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.format.message", Locale.CHINA);
		
		String driver = rb.getString("jdbc.driver");
		
		System.out.println(driver);
		
	}

}
