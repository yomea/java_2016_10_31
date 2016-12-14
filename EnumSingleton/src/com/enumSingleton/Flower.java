package com.enumSingleton;

/**
 * 单例模式有懒汉模式和饿汉模式
 * 现在补充一个枚举单例
 * @author may
 *
 */
public enum Flower {
	INSTANCE("梅花", "铮铮傲骨，不卑不亢");
	
	private String name;
	
	private String flowerLanguage;
	
	private Flower(String name, String flowerLanguage) {
		
		this.name = name;
		this.flowerLanguage = flowerLanguage;
	}

	public String getName() {
		return name;
	}

	public String getFlowerLanguage() {
		return flowerLanguage;
	}
	
	

}
