package com.joelkingsley.rmkcet.spas.fe.beans;

import java.io.Serializable;

public class Semester implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int semesterID;
	int semesterNumber;
	Batch batch;
	Department department;
	
	public Semester(int semesterID, int semesterNumber, Batch batch, Department department) {
		super();
		this.semesterID = semesterID;
		this.semesterNumber = semesterNumber;
		this.batch = batch;
		this.department = department;
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

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Semester [semesterID=" + semesterID + ", semesterNumber=" + semesterNumber + ", batch=" + batch
				+ ", department=" + department + "]";
	}
	
}
