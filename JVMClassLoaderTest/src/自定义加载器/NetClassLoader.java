package 自定义加载器;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class NetClassLoader extends ClassLoader {
	
	private String rootURL = "";
	
	public NetClassLoader(String rootURL) {
		
		this.rootURL = rootURL;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		
		Class<?> c = findLoadedClass(name);
		
		if(c != null) {
			
			return c;
		}
		
		try {
			ClassLoader parent = this.getParent();
			
			c = parent.loadClass(name);
			
			if(c != null) {
				
				return c;
			}
			
		} catch (Exception e) {
			
		}
		
		byte[] buff = this.getClassByte(name); 
		
		c = this.defineClass(name, buff, 0, buff.length);
		
		if(c == null) {
			
			try {
				throw new Exception("类未找到！！！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return c;
	}

	private byte[] getClassByte(String name) {
		
		String path = rootURL + "/" + name.replace('.', '/') + ".class";
		byte[] buff = null;
		
		
		try(
				InputStream in = new URL(path).openStream();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
			) {
			int len = 0;
			buff = new byte[1024];
			while((len = in.read(buff)) != -1) {
				out.write(buff, 0, len);
				
			}
			
			buff = out.toByteArray();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return buff;
	}
	
	
	
	

}
