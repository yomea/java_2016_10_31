package javaCompiler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		String javaStr = "public class Helloworld{public static void main(String[] args) {System.out.println(\"Hello World!!!\");}}";
		
		File file = new File("D:/javaCompiler", "Helloworld.java");
		
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
			
		}
		
		FileOutputStream out  = new FileOutputStream(file);
		
		out.write(javaStr.getBytes());
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		
	/*	Runtime runTime = Runtime.getRuntime();
		
		runTime.exec("javac -cp D:/javaCompiler/ Helloworld.java");
		*/
		
		int result = compiler.run(null, null,  null, "D:/javaCompiler/Helloworld.java");
		
		System.out.println(result == 0 ? "编译成功" : "编译失败");
		
		URL[] urls = new URL[] {new URL("file:/D:/javaCompiler/")};
		
		URLClassLoader urlClassLoader = new URLClassLoader(urls);
		//加载urls指定目录下的Java类，不需要.class后缀
		Class<?> helloWorld = urlClassLoader.loadClass("Helloworld");
		
		Method main = helloWorld.getDeclaredMethod("main", String[].class);
		
		main.invoke(null, (Object)new String[]{} );
		
		Runtime runTime = Runtime.getRuntime();
		
		Process process = runTime.exec("java -cp D:/javaCompiler/ Helloworld");
		
		InputStream in = process.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while(-1 != (len = in.read(buf))) {
			System.out.println(new String(buf, 0, len));
			
		}
		
		CloseUtil.close(out, urlClassLoader);
		
	}

}
