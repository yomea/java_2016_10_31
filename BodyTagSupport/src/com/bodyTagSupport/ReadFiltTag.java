package com.bodyTagSupport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ReadFiltTag extends TagSupport {
	
	private static final long serialVersionUID = 3797635208525308453L;
	
	private String src;
	
	public void setSrc( String src) {
		
		this.src = src;
	}
	
	@Override
	public int doStartTag() throws JspException {
		
		InputStream in = pageContext.getServletContext().getResourceAsStream(src);
		
		InputStreamReader isr = new InputStreamReader(in);
		
		BufferedReader bin = new BufferedReader(isr);
		
		Writer writer = pageContext.getOut();
		
		String str = "";

		try {
			while(null != (str = bin.readLine())) {
				writer.write(str + "\r\n");
			}
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}

}
