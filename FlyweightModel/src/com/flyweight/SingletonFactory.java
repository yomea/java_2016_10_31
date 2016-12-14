package com.flyweight;

import java.util.HashMap;
import java.util.Map;

public class SingletonFactory {
	
	private Map<Character, Flyweight> map = new HashMap<>();
	
	private static SingletonFactory singletonFactory = new SingletonFactory();
	
	private SingletonFactory() {}
	
	public static SingletonFactory newInstance() {
		
		return singletonFactory;
		
	}
	
	public Flyweight getFlyweight(Character intrinsicState) {
		
		if(map.containsKey(intrinsicState)) {
			
			return map.get(intrinsicState);
		}
		
		Flyweight flyweight = new ConcreteFlyweight(intrinsicState);
		
		map.put(intrinsicState, flyweight);
		
		return flyweight;
	}
	

}
