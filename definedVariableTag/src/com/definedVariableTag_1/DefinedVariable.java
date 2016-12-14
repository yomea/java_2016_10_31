package com.definedVariableTag_1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class DefinedVariable extends TagSupport {
	
	private String name;
	
	private String type;
	
	private String scope;
	
	private static final long serialVersionUID = 821726076291699072L;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return super.doAfterBody();
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		
		try {
			//用过类名来定义对象
			Object obj = Class.forName(type).newInstance();
			//根据定义的范围来存储这个对象
			if(scope.equalsIgnoreCase("request")) {
				
				pageContext.setAttribute(name, obj, PageContext.REQUEST_SCOPE);
				
			} else if(scope.equalsIgnoreCase("session")) {
				pageContext.setAttribute(name, obj, PageContext.SESSION_SCOPE);
				
			} else if(scope.equalsIgnoreCase("page")) {
				pageContext.setAttribute(name, obj, PageContext.PAGE_SCOPE);
				
			} else if(scope.equalsIgnoreCase("pageContext")) {
				pageContext.setAttribute(name, obj);
				
			} else if(scope.equalsIgnoreCase("application")) {
				
				pageContext.setAttribute(name, obj, PageContext.APPLICATION_SCOPE);
			} else {
				
				throw new RuntimeException("未知范围！！！");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		return super.doStartTag();
		
	}
	
	
	
	

}
