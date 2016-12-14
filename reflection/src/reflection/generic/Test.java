package reflection.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

import reflection.User;

public class Test {

	public void test1(Map<String, Date> map, List<User> users) {

	}

	public Map<String, Date> test2() {

		return null;
	}
	
	public static void main(String[] args) throws Exception {
		
		Class<Test> test = Test.class;
		
		Method test1 = test.getMethod("test1", Map.class, List.class);
		
		Type[] type = test1.getGenericParameterTypes();
		
		//得到参数的类型，不含泛型
		/**
		 * java.util.Map
		 *	java.util.List
		
		Class<?>[] parameterTypes = test1.getParameterTypes();
		
		for (Class<?> class1 : parameterTypes) {
			System.out.println(class1.getName());
		}
		*/
		/**
		 *	java.util.Map<java.lang.String, java.util.Date>
		 *	java.util.List<reflection.User>
		 * class sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
		for (Type type2 : type) {
			System.out.println(type2.getClass());
			System.out.println(type2);
		}
		 */
		
		
		for (Type type2 : type) {
			/**
			 * class java.lang.String
			 * 	class java.util.Date
			 * class reflection.User
			 */
			if(type2 instanceof ParameterizedType) {
				Type[] actualTypeArguments = ((ParameterizedType)type2).getActualTypeArguments();
				Type rawType = ((ParameterizedType)type2).getRawType();
				Type ownerType = ((ParameterizedType)type2).getOwnerType();
				System.out.println("参数类型--》" + rawType);
				for (Type type3 : actualTypeArguments) {
					System.out.println(type3);
				}
			}
		}
	}

}
