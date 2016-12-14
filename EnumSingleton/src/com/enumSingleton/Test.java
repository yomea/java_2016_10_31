package com.enumSingleton;

public class Test {
	
	public static void main(String[] args) {
		
		String name = Flower.INSTANCE.getName();
		
		String flowerLanguage = Flower.INSTANCE.getFlowerLanguage();
		
		System.out.println(name + "象征着" + flowerLanguage);
		
	}

}
