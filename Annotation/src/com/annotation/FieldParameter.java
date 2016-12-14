package com.annotation;

/**
 * 定义Field注解对应的参数
 * @author may
 *
 */
public class FieldParameter {
	
	private String columnName;
	
	private String type;
	
	private int length;
	
	public FieldParameter() {}
	

	public FieldParameter(String columnName, String type, int length) {
		super();
		this.columnName = columnName;
		this.type = type;
		this.length = length;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	

}
