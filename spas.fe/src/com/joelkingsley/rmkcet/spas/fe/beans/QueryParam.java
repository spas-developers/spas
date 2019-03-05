package com.joelkingsley.rmkcet.spas.fe.beans;

public class QueryParam {

	String attribute;
	String value;
	
	public QueryParam(String attribute, String value) {
		super();
		this.attribute = attribute;
		this.value = value;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "QueryParam [attribute=" + attribute + ", value=" + value + "]";
	}
	
	
}
