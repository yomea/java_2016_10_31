package com.userDefined.dynamic_attributes_tag;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("all")
public class ListTag extends TagSupport implements DynamicAttributes {
	
	private String name;
	
	private Map map = new HashMap();
	
	public void setName(String name) {
		
		this.name = name;
	}

	private static final long serialVersionUID = 5305096017079792339L;

	@Override
	public int doAfterBody() throws JspException {
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		
		Set list = map.entrySet();
		
		try {
			out.print("<select name='" + name + "'>");
			
			Iterator it = list.iterator();
			
			while(it.hasNext()) {
				Map.Entry entry = (Entry) it.next();
				
				out.print("<option value='");
				
				out.print(entry.getKey());
				
				out.print("'>");
				
				out.print(entry.getValue());
				
				out.print("</option>");
				
			}
			
		} catch (Exception e) {
			
		}
		
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public void setDynamicAttribute(String url, String localName, Object value) throws JspException {
		
		map.put(localName, value);
		
	}
	
	
	
	
	
	

}
