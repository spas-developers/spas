package com.joelkingsley.rmkcet.spas.fe.services;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.fe.beans.Exam;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddExamRequest;
import com.joelkingsley.rmkcet.spas.fe.delegates.ExamsDelegate;

public class ExamsService {
	ExamsDelegate examsDelegate;
	
	public ExamsService() {
		super();
		examsDelegate = new ExamsDelegate();
	}
	
	public ArrayList<Exam> getAllExams() {
		return examsDelegate.getAllExams();
	}
	
	public AddExamRequest addExam(AddExamRequest addExamRequest) {
		return examsDelegate.addExam(addExamRequest);
	}
}
