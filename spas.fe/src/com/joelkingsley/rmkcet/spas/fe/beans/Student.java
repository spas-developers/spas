package com.joelkingsley.rmkcet.spas.fe.beans;

import java.io.Serializable;
import java.math.BigInteger;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int studentID;
	BigInteger registerNumber; 
	String studentName;
	String gender;
	boolean isHosteler;
	Batch batch;
	Department department;
	
	public Student(int studentID, BigInteger registerNumber, String studentName, String gender, boolean isHosteler,
			Batch batch, Department department) {
		super();
		this.studentID = studentID;
		this.registerNumber = registerNumber;
		this.studentName = studentName;
		this.gender = gender;
		this.isHosteler = isHosteler;
		this.batch = batch;
		this.department = department;
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
		return "Student [studentID=" + studentID + ", registerNumber=" + registerNumber + ", studentName=" + studentName
				+ ", gender=" + gender + ", isHosteler=" + isHosteler + ", batch=" + batch + ", department="
				+ department + "]";
	}
	
	

}
