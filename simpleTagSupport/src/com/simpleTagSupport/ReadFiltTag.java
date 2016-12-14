package com.simpleTagSupport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ReadFiltTag extends SimpleTagSupport {

	private String src;

	public void setSrc(String src) {

		this.src = src;
	}

	@Override
	public void doTag() throws JspException, IOException {
		//jspContext是pagecontext的父类
		PageContext pageContext = (PageContext) this.getJspContext();

		InputStream in = pageContext.getServletContext().getResourceAsStream(src);

		InputStreamReader isr = new InputStreamReader(in);

		BufferedReader bin = new BufferedReader(isr);

		Writer writer = pageContext.getOut();

		String str = "";

		try {
			while (null != (str = bin.readLine())) {
				writer.write(str + "\r\n");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
