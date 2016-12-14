package com.copyDirectory;

import java.io.Closeable;
import java.io.IOException;

public class ResoucesClose {
	
	public static <T extends Closeable> void close(@SuppressWarnings("unchecked") T... resources) {
		for (T t : resources) {
			if(t != null) {
				try {
					t.close();
				} catch(IOException e) {
					e.printStackTrace();
					
				}
			}
		}
		
	}

}
