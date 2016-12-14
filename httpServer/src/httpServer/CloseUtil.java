package httpServer;

import java.io.Closeable;
import java.io.IOException;
/**
 * 关闭资源类
 * @author may
 *
 */
public class CloseUtil {
	
	/**
	 * 关闭一切实现了closeable接口的类
	 * @param c
	 */
	@SafeVarargs
	public static <T extends Closeable> void close(T... c) {
		
		for (T t : c) {
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
