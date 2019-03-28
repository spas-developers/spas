package com.joelkingsley.rmkcet.spas.fe.beans.requests;

import java.io.Serializable;

public class AddExamRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int examID;
	int examTypeID;
	int subjectID;
	int semesterID;
	
	
	
	public AddExamRequest() {
		super();
	}

	public AddExamRequest(int examID, int examTypeID, int subjectID, int semesterID) {
		super();
		this.examID = examID;
		this.examTypeID = examTypeID;
		this.subjectID = subjectID;
		this.semesterID = semesterID;
	}
	
	

	public AddExamRequest(int examTypeID, int subjectID, int semesterID) {
		super();
		this.examTypeID = examTypeID;
		this.subjectID = subjectID;
		this.semesterID = semesterID;
	}

	public int getExamID() {
		return examID;
	}

	public void setExamID(int examID) {
		this.examID = examID;
	}

	public int getExamTypeID() {
		return examTypeID;
	}

	public void setExamTypeID(int examTypeID) {
		this.examTypeID = examTypeID;
	}

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public int getSemesterID() {
		return semesterID;
	}

	public void setSemesterID(int semesterID) {
		this.semesterID = semesterID;
	}

	@Override
	public String toString() {
		return "AddExamRequest [examID=" + examID + ", examTypeID=" + examTypeID + ", subjectID=" + subjectID
				+ ", semesterID=" + semesterID + "]";
	}
	
	
}
