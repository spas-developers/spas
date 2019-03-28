package com.joelkingsley.rmkcet.spas.fe.beans.requests;

import java.io.Serializable;

public class AddExamResultRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int examResultID;
	int examID;
	int studentID;
	int marks;
	String grade;
	
	public AddExamResultRequest() {
		super();
	}

	public AddExamResultRequest(int examResultID, int examID, int studentID, int marks, String grade) {
		super();
		this.examResultID = examResultID;
		this.examID = examID;
		this.studentID = studentID;
		this.marks = marks;
		this.grade = grade;
	}

	public AddExamResultRequest(int examID, int studentID, int marks, String grade) {
		super();
		this.examID = examID;
		this.studentID = studentID;
		this.marks = marks;
		this.grade = grade;
	}

	public int getExamResultID() {
		return examResultID;
	}

	public void setExamResultID(int examResultID) {
		this.examResultID = examResultID;
	}

	public int getExamID() {
		return examID;
	}

	public void setExamID(int examID) {
		this.examID = examID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "AddExamResultRequest [examResultID=" + examResultID + ", examID=" + examID + ", studentID=" + studentID
				+ ", marks=" + marks + ", grade=" + grade + "]";
	}
	
	
	
}
