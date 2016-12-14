package javaExecution;

public class Test {
	
	public static void main(String[] args) {
		
		/**
		 * 执行顺序
		 * A static execute
		 *	B static execute
		 *	A dynamic execute
		 *	create A
		 *	B dynamic execute
		 *	create B

		 */
		
		new B();
		
	}

}
