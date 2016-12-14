package com.bodyTagSupport;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class HtmlFilterTag extends BodyTagSupport {

	private static final long serialVersionUID = -1208959209150025651L;

	@Override
	public int doEndTag() throws JspException {
		
		String str = this.bodyContent.getString();
		str = filterStr(str);
		System.out.println(str);
		try {
			this.bodyContent.getEnclosingWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return HtmlFilterTag.EVAL_PAGE;
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
