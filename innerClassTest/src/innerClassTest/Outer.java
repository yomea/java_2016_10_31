package innerClassTest;

import java.util.Date;

public class Outer {
	
	public int a;
	
	public class Inner {
		
		static final int a = 8;//允许，因为在编译期可以确定，它知道你定义的是什么
		（X） static final Date date = new Date();//错误！因为这个在编译期不能确定，它不知道你是不是new的是Inner
		//错误！反正法，如果可以，那么可以直接Outer.Inner.inner拿到Inner的对象
		//一个成员非静态的内部类居然可以直接获取到而不用通过外部对象取得，又悖设计初衷
		//a这个变量尚且只有new出Outer对象才能获取，而这个却直接可以获取，这是不公平的，
		//为了杜绝这种问题，相当于一竿子打死一船人。除了编译期可以确定的，
		//其他的不确定的视为出错
		//涉及到Java设计的原理，不必纠结
		（X）static Inner inner = new Inner();
	
		
	}

}
