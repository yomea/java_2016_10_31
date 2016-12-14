package com.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义表注解
 * @author may
 *
 */
@Documented//被这个注解注解的注解注解在一个类上，当这个类生成javadoc时会将这个注解的信息写到javadoc上
@Target(value={ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
 //如果父类的注解是定义在类上面，那么子类是可以继承过来的  
//如果父类的注解定义在方法上面，那么子类仍然可以继承过来  
//如果子类重写了父类中定义了注解的方法，那么子类将无法继承该方法的注解  
//即子类在重写父类中被@Inherited标注的方法时，会将该方法连带它上面的注解一并覆盖掉  
//【注意】JDK文档中对此种情况的叙述并不全面  
//〖另外〗接口的实现类是无法继承接口中所定义的被@Inherited标注的注解的
@Inherited
public @interface Table {
	
	String value();
	
}
