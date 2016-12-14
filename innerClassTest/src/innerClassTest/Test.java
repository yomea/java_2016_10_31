package innerClassTest;

import innerClassTest.Outer.Inner;

public class Test {
	
	public static void main(String[] args) {
		
		Outer outer = new Outer();
		
		Inner inner = outer.new Inner();
		
		System.out.println(Outer.Inner.a);
		
	}

}
