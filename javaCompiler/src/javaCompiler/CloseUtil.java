package javaCompiler;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {
	
	@SafeVarargs
	public static <T extends Closeable> void close(T... ts) {
		for (T t : ts) {
			if(t != null) {
				try {
					t.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

}
