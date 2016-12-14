package reflection;

import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		try {
			Test.test1();
			Test.test2();
			Test.test3();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test1() {

		User user = new User();

		long start = System.currentTimeMillis();

		for (int i = 0; i < 1000000000L; i++) {
			user.getName();

		}

		long end = System.currentTimeMillis();

		System.out.println("调用普通方法用时：" + (end - start) + "ms");

	}

	@SuppressWarnings("all")
	public static void test2() throws Exception {

		Class<?> user = User.class;

		Method test = user.getMethod("getName");

		long start = System.currentTimeMillis();

		for (int i = 0; i < 1000000000L; i++) {
			test.invoke(user.newInstance());

		}

		long end = System.currentTimeMillis();

		System.out.println("调用普通反射方法用时：" + (end - start) + "ms");

	}
	
	public static void test3() throws Exception {

		Class<User> user = User.class;

		Method test = user.getMethod("getName");
		//开启无需检查访问权限
		test.setAccessible(true);
		
		long start = System.currentTimeMillis();

		for (int i = 0; i < 1000000000L; i++) {
			test.invoke(user.newInstance());

		}

		long end = System.currentTimeMillis();

		System.out.println("调用免检反射方法用时：" + (end - start) + "ms");

	}

}
