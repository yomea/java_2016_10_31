package com.definedVariableTag_2;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

public class MyTagEx extends TagExtraInfo {

	@Override
	public VariableInfo[] getVariableInfo(TagData data) {
		return new VariableInfo[] { new VariableInfo(data.getAttributeString("name"), data.getAttributeString("type"),
				true, PageContext.REQUEST_SCOPE) };
	}

}
