package com.joelkingsley.rmkcet.spas.fe.beans;

public class ExamResult {

	int examResultID;
	int marks;
	String grade;
	Exam exam;
	Student student;
	
	public ExamResult(int examResultID, int marks, String grade, Exam exam, Student student) {
		super();
		this.examResultID = examResultID;
		this.marks = marks;
		this.grade = grade;
		this.exam = exam;
		this.student = student;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "ExamResult [examResultID=" + examResultID + ", marks=" + marks + ", grade=" + grade + ", exam=" + exam
				+ ", student=" + student + "]";
	}
		
}
