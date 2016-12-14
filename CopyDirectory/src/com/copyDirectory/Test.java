package com.copyDirectory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		FileUtil.copyDir("D:/temp/hehe", "D:/temp/test");
		
		
	}
	
}
