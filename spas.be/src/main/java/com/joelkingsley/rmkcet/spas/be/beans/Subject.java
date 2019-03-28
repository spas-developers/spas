package com.joelkingsley.rmkcet.spas.be.beans;

import java.io.Serializable;

public class Subject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int subjectID;
	String subjectCode;
	String subjectName;
	int credit;
	
	public Subject(int subjectID, String subjectCode, String subjectName, int credit) {
		super();
		this.subjectID = subjectID;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.credit = credit;
	}

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Subject [subjectID=" + subjectID + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName
				+ ", credit=" + credit + "]";
	}

	public Subject() {
		super();
	}
	
	
}
