package com.facade;

import com.facade.instance.Light;
import com.facade.instance.TV;

public class FacadeTest {
	
	private static FacadeTest facadeTest = new FacadeTest();
	
	
	private FacadeTest() {}
	
	public static FacadeTest newInstance() {
		
		return facadeTest;
	}
	
	public void on() {
		
		new Light().on();
		new TV().on();
	}
	
	public void off() {
		
		new Light().off();
		new TV().off();
	}

}
