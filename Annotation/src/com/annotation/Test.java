package com.annotation;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	private static final String CRLF = "\r\n";
	
	private static final String BLANK = " ";
	
	public static void main(String[] args) {
		
		Class<User> clazz = User.class;
		
		StringBuilder sql = new StringBuilder();
		//拿到类注解
		Table table = clazz.getDeclaredAnnotation(Table.class);
		//得到注解的值，即表名
		String tableName = table.value();
		//拿到所有的成员变量
		java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
		
		List<FieldParameter> list = new ArrayList<>();
		
		String idName = null;
		
		for (int i = 0; i < fields.length; i++) {
			Field fieldAnnotation = fields[i].getDeclaredAnnotation(Field.class);
			
			Id id = fields[i].getDeclaredAnnotation(Id.class);
			//如果定义了ID注解，那么进行处理
			if(id != null) {
				idName = id.value();
				
			}
			if(fieldAnnotation != null) {
				
				FieldParameter tableField = new FieldParameter(fieldAnnotation.column(), fieldAnnotation.type(), fieldAnnotation.length());
				
				list.add(tableField);
			}
			
			
		}
		
		sql.append("create table ").append(tableName).append("(").append(CRLF);
		if(idName != null) {
			sql.append("\t").append(idName).append(BLANK).append("int primary key auto_increment,").append(CRLF);
			
		}
		for (FieldParameter tableField : list) {
			sql.append("\t").append(tableField.getColumnName()).append(BLANK).append(tableField.getType()).append("("+tableField.getLength()+")").append(",").append(CRLF);
			
		}
		
		sql.deleteCharAt(sql.length()-3);
		
		sql.append(");");
		
		System.out.println(sql.toString());		
	}

}
