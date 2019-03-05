package com.joelkingsley.rmkcet.spas.fe.beans;

import java.io.Serializable;

public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int departmentID;
	String departmentName;
	String abbreviation;

	public Department(int departmentID, String departmentName, String abbreviation) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.abbreviation = abbreviation;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + ", abbreviation="
				+ abbreviation + "]";
	}
	
}
