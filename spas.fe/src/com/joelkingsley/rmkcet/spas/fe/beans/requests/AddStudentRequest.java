package com.joelkingsley.rmkcet.spas.fe.beans.requests;

import java.math.BigInteger;

public class AddStudentRequest {

	int studentID;
	BigInteger registerNumber; 
	String studentName;
	String gender;
	boolean isHosteler;
	int batchID;
	int departmentID;
	
	public AddStudentRequest(int studentID, BigInteger registerNumber, String studentName, String gender,
			boolean isHosteler, int batchID, int departmentID) {
		super();
		this.studentID = studentID;
		this.registerNumber = registerNumber;
		this.studentName = studentName;
		this.gender = gender;
		this.isHosteler = isHosteler;
		this.batchID = batchID;
		this.departmentID = departmentID;
	}

	public AddStudentRequest() {
		super();
	}

	public AddStudentRequest(BigInteger registerNumber, String studentName, String gender, boolean isHosteler,
			int batchID, int departmentID) {
		super();
		this.registerNumber = registerNumber;
		this.studentName = studentName;
		this.gender = gender;
		this.isHosteler = isHosteler;
		this.batchID = batchID;
		this.departmentID = departmentID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public BigInteger getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(BigInteger registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isHosteler() {
		return isHosteler;
	}

	public void setHosteler(boolean isHosteler) {
		this.isHosteler = isHosteler;
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
		return "AddStudentRequest [studentID=" + studentID + ", registerNumber=" + registerNumber + ", studentName="
				+ studentName + ", gender=" + gender + ", isHosteler=" + isHosteler + ", batchID=" + batchID
				+ ", departmentID=" + departmentID + "]";
	}
	
	
	
}
