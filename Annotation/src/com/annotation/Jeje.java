package com.annotation;

import java.lang.annotation.Annotation;
//所有的注解默认实现了 java.lang.annotation.Annotation;
@Table("")
public class Jeje implements Table {

	@Override
	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String value() {
		// TODO Auto-generated method stub
		return null;
	}


}
