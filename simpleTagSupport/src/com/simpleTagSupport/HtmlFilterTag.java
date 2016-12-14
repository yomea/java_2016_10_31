package com.simpleTagSupport;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HtmlFilterTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		
		StringWriter stringWriter = new StringWriter();
		
		this.getJspBody().invoke(stringWriter);
		
		String content = this.filterStr(stringWriter.toString());
		
		this.getJspContext().getOut().write(content);
		
		super.doTag();
	}

	private String filterStr(String str) {
		
		if(str == null) {
			return null;
		}
		
		char[] charArr = new char[str.length()];
		
		str.getChars(0, str.length(), charArr, 0);
		
		StringBuilder sb = new StringBuilder(); 
		
		for (char c : charArr) {
			
			switch(c) {
			case '<' : 
				sb.append("&lt;");
				break;
			case '>' : 
				sb.append("&gt;");
				break;
			case '&' : 
				sb.append("&amp;");
				break;
			case '"' : 
				sb.append("&quot;");
				break;
			default :
				sb.append(c);
			
			}
			
		}
		
		return sb.toString();
	}
	
	

}
