package com.bjsxt.test;

/**
 * ���Ը�������(class,interface,enum,annotation,primitive type,void)��Ӧ��java.lang.Class����Ļ�ȡ��ʽ
 * @author ��ѧ�ø��    www.sxt.cn
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	
	public static void main(String[] args) {
		String path = "com.bjsxt.test.bean.User";
		
		try {
			
			Class clazz = Class.forName(path);
			//�����Ǳ�ʾ���װһЩ���ݡ�  һ���౻���غ�JVM�ᴴ��һ����Ӧ�����Class������������ṹ��Ϣ��ŵ���Ӧ��Class�����С�
			//���Class�������һ�澵��һ����ͨ�����澵���ҿ��Կ�����Ӧ���ȫ����Ϣ��
			System.out.println(clazz.hashCode());
			
			Class clazz2 = Class.forName(path);	//һ����ֻ��Ӧһ��Class����
			System.out.println(clazz2.hashCode());
			
			Class strClazz = String.class;
			Class strClazz2 = path.getClass(); 
			System.out.println(strClazz==strClazz2);
			
			Class intClazz =int.class;
			
			int[] arr01 = new int[10];
			int[][] arr02 = new int[30][3];
			int[] arr03 = new int[30];
			double[] arr04 = new double[10];
			
			System.out.println(arr01.getClass().hashCode());
			System.out.println(arr02.getClass().hashCode());
			System.out.println(arr03.getClass().hashCode());
			System.out.println(arr04.getClass().hashCode());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}