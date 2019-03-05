package com.joelkingsley.rmkcet.spas.be.beans;

public class ExamResult {

	int examResultID;
	int marks;
	String grade;
	Exam exam;
	ExamType examType;
	
	public ExamResult(int examResultID, int marks, String grade, Exam exam, ExamType examType) {
		super();
		this.examResultID = examResultID;
		this.marks = marks;
		this.grade = grade;
		this.exam = exam;
		this.examType = examType;
	}

	public int getExamResultID() {
		return examResultID;
	}

	public void setExamResultID(int examResultID) {
		this.examResultID = examResultID;
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

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public ExamType getExamType() {
		return examType;
	}

	public void setExamType(ExamType examType) {
		this.examType = examType;
	}

	@Override
	public String toString() {
		return "ExamResult [examResultID=" + examResultID + ", marks=" + marks + ", grade=" + grade + ", examType="
				+ examType + "]";
	}
	
	
	
}
