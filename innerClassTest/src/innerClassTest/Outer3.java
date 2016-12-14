package innerClassTest;

public class Outer3 {
	
	public int a;
	
	public void test() {
		
		（X）（static 或者 private，public， protected） class Inner3 { //错误！局部内部类，不能使用修饰词,局部类只能在本方法中可用
			
			public int a;//没问题
			
			（X）static int b; //错误！局部内部类，不能使用static
			 
			
		}
		
	}

}
