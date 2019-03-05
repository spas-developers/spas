package com.joelkingsley.rmkcet.spas.be.beans;

import java.io.Serializable;

public class ExamType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int examTypeID;
	String examTypeName;
	String abbrevation;
	public ExamType(int examTypeID, String examTypeName, String abbrevation) {
		super();
		this.examTypeID = examTypeID;
		this.examTypeName = examTypeName;
		this.abbrevation = abbrevation;
	}
	public int getExamTypeID() {
		return examTypeID;
	}
	public void setExamTypeID(int examTypeID) {
		this.examTypeID = examTypeID;
	}
	public String getExamTypeName() {
		return examTypeName;
	}
	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}
	public String getAbbrevation() {
		return abbrevation;
	}
	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}
	@Override
	public String toString() {
		return "ExamType [examTypeID=" + examTypeID + ", examTypeName=" + examTypeName + ", abbrevation=" + abbrevation
				+ "]";
	}
	

}
