package com.joelkingsley.rmkcet.spas.fe.services;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.fe.beans.ExamType;
import com.joelkingsley.rmkcet.spas.fe.delegates.ExamTypesDelegate;

public class ExamTypesService {
ExamTypesDelegate examTypesDelegate;
	
	public ExamTypesService() {
		super();
		examTypesDelegate = new ExamTypesDelegate();
	}
	
	public ArrayList<ExamType> getAllExamTypes() {
		return examTypesDelegate.getAllExamTypes();
	}
	
	public ExamType addExamType(ExamType examType) {
		return examTypesDelegate.addExamType(examType);
	}
}
