package com.joelkingsley.rmkcet.spas.be.beans.requests;

import java.io.Serializable;

import com.joelkingsley.rmkcet.spas.be.beans.Batch;
import com.joelkingsley.rmkcet.spas.be.beans.Department;

public class AddSemesterRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int semesterID;
	int semesterNumber;
	int batchID;
	int departmentID;
	
	public AddSemesterRequest() {
		super();
	}
	public AddSemesterRequest(int semesterID, int semesterNumber, int batchID, int departmentID) {
		super();
		this.semesterID = semesterID;
		this.semesterNumber = semesterNumber;
		this.batchID = batchID;
		this.departmentID = departmentID;
	}
	public int getSemesterID() {
		return semesterID;
	}
	public void setSemesterID(int semesterID) {
		this.semesterID = semesterID;
	}
	public int getSemesterNumber() {
		return semesterNumber;
	}
	public void setSemesterNumber(int semesterNumber) {
		this.semesterNumber = semesterNumber;
	}
	public int getBatchID() {
		return batchID;
	}
	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	@Override
	public String toString() {
		return "AddSemesterRequest [semesterID=" + semesterID + ", semesterNumber=" + semesterNumber + ", batchID="
				+ batchID + ", departmentID=" + departmentID + "]";
	}
	
	
}

	
	



