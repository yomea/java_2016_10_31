package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义字段注解
 * @author may
 *
 */
@Target(value={ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {
	
	String column();
	
	String type();
	
	int length();

}
