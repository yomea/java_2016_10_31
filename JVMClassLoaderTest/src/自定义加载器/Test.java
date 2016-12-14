package 自定义加载器;

public class Test {
	public static void main(String[] args) throws Exception {
		
		FileSystemClassLoader loader = new FileSystemClassLoader("D:/javaCompiler");
		
		Class<?> clazz = loader.loadClass("Helloworld");
		
		System.out.println(clazz.getClassLoader());//自定义加载器.FileSystemClassLoader@6d06d69c
		
		
		
	}

}
