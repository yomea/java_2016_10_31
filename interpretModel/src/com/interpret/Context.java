package com.interpret;

import java.util.HashMap;
import java.util.Map;

public class Context {
	
	private Map<String, Boolean> map = new HashMap<>();
	
	
	public boolean getValue(String key) {
		
		return map.get(key);
		
	}
	
	public void addValue(String key, Boolean value) {
		
		map.put(key, value);
	}
	
	
	

}
