package 双亲委托;

/**
 * 像这种自己写的Java类，是由app加载器加载，由于双亲委托机制的存在，
 * 它会先让父加载器去加载类，如果父加载器在它的加载路径找到了同名的类，
 * 就会由父加载器来加载。显然这里的String类是rt.jar中的类，所以引导加载器
 * 会加载它。 
 * @author may
 *
 */
public class Test {
	
	public static void main(String[] args) {
		
		String a = "aaa";
		
		System.out.println(a.getClass().getClassLoader());//它的加载器是bootstrap加载器，用c写的加载器
		
		
		
	}

}
