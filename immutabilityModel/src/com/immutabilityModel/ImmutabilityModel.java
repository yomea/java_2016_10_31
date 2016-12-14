package com.immutabilityModel;

/**
 * 不变模式分为弱不变模式和强不变模式
 * 所谓不变就是这个对象创建后就不能更改
 * 这个类也不提供修改值得方法
 * 弱不变类：
 * 		父类不能被改变，子类可以改变，或者子类可改变父类的值
 * 强不变类：
 * 		父类是final的，也就是没有子类，彻底的不变
 * 比如String,还有Long什么的都是不变类
 * @author may
 *
 */
public final class ImmutabilityModel {
	
	private String hello;
	
	public ImmutabilityModel(String hello) {
		this.hello = hello;
		
	}
	
	public String getValue() {
		
		return hello;
	}
	
	public ImmutabilityModel setValue(String hello) {
		//乍一看，有个setValue的方法，但是它修改的不是当前对象的值，而是有new出来一个
		return new ImmutabilityModel(hello);
	}

}
