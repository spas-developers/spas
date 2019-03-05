package com.joelkingsley.rmkcet.spas.fe.beans;

import java.io.Serializable;

public class Exam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int examID;
	ExamType examType;
	Subject subject;
	Semester semester;

	public Exam(int examID, ExamType examType, Subject subject, Semester semester) {
		super();
		this.examID = examID;
		this.examType = examType;
		this.subject = subject;
		this.semester = semester;
	}
	public int getExamID() {
		return examID;
	}
	public void setExamID(int examID) {
		this.examID = examID;
	}
	public ExamType getExamType() {
		return examType;
	}
	public void setExamType(ExamType examType) {
		this.examType = examType;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	@Override
	public String toString() {
		return "Exam [examID=" + examID + ", examType=" + examType + ", subject=" + subject + ", semester=" + semester
				+ "]";
	}
	

}
