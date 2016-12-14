package 加密和解密;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Encode {
	
	public static void main(String[] args) throws Exception {
		
		InputStream in = Encode.class.getResourceAsStream("Employee.class");
		
		OutputStream out = new FileOutputStream("D:/javaCompiler/Employee.class");
		
		int bye = 0;
		
		while((bye = in.read()) != -1) {
			out.write(bye^0xff);
			
		}
		
		out.close();
		in.close();
		
	}

}
