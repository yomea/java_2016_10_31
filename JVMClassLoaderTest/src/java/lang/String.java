package java.lang;

import java.lang.String;

public class String {
	
	private String test;
	
	public String(String test) {
		this.test = test;
		
	}
	
	public String toString() {
		
		return "经过 " + test +  "自定义String永远不会被加载！！！";
		
	}

}
