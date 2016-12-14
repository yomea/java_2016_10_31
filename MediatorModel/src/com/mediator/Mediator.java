package com.mediator;

public interface Mediator {
	
	//经理可以为中介者
	//每个部门都有经理的引用
	//经理有个Map存着每个部门
	//经理提供某个方法来要求经理去命令其他部门做一些事情，也就是部门之间不会直接
	//通信，都是通过经理这个中介者来通信

}
