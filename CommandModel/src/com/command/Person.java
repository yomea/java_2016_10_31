package com.command;

/**
 * 客户端类。发出命令者
 * @author may
 *
 */
public class Person {
	
	public static void main(String[] args) {
		
		TV tv = new TV();
		
		Command offCommand = new OffCommand(tv);
		
		Command onCommand = new OnCommand(tv);
		
		Controll controll = new ControllImpl(offCommand, onCommand);
		
		controll.execute();
		
		
	}

}
