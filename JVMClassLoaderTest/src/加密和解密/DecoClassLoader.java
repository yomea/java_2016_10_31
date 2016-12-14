package 加密和解密;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class DecoClassLoader extends ClassLoader {

	private String rootDir = "";
	
	public DecoClassLoader(String rootDir) {
		
		this.rootDir = rootDir;
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
		
		String path = rootDir + "/" + name.replace('.', '/') + ".class";
		byte[] buff = null;
		
		try(
				InputStream in = new FileInputStream(path);
				ByteArrayOutputStream out = new ByteArrayOutputStream();
			) {
			int b = 0;
			while((b = in.read()) != -1) {
				out.write(b^0xff);
				
			}
			
			buff = out.toByteArray();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return buff;
	}
	
	
}
