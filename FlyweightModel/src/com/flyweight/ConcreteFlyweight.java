package com.flyweight;

public class ConcreteFlyweight implements Flyweight {

	private Character intrinsicState = null;
	
	
	public ConcreteFlyweight(Character intrinsicState) {
		this.intrinsicState = intrinsicState;
	}
	
	//一个示意性的方法，参数state是外蕴状态
	@Override
	public void operation(String state) {
		//外蕴指的是周围的环境，不影响内蕴状态
		System.out.println("intrinsicState:" + intrinsicState + ",外蕴：" + state);

	}

}
