package com.simpleTagSupport.jspFrament;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class JspFragmentTest extends SimpleTagSupport {
	
	private JspFragment jspFragment1;
	
	private JspFragment jspFragment2;
	
	public void setJspFragment1(JspFragment jspFragment1) {
		this.jspFragment1 = jspFragment1;
		
	}
	
	public void setJspFragment2(JspFragment jspFragment2) {
		this.jspFragment2 = jspFragment2;
		
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		
		this.jspFragment1.invoke(null);
		
		this.jspFragment2.invoke(null);
		
		this.getJspBody().invoke(null);
		
		super.doTag();
	}

}
