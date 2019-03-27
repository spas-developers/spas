package com.joelkingsley.rmkcet.spas.fe.services;

import java.math.BigInteger;
import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.fe.beans.ExamResult;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddExamResultRequest;
import com.joelkingsley.rmkcet.spas.fe.delegates.ExamResultsDelegate;

public class ExamResultsService {

	ExamResultsDelegate examResultsDelegate;
	
	public ExamResultsService() {
		super();
		examResultsDelegate = new ExamResultsDelegate();
	}

	public ArrayList<ExamResult> getAllExamResultsOfRegisterNumber(BigInteger registerNumber) {
		return examResultsDelegate.getAllExamResultsOfRegisterNumber(registerNumber);
	}
	
	public AddExamResultRequest addExamResultRequest(AddExamResultRequest addExamResultRequest) {
		return examResultsDelegate.addExamResult(addExamResultRequest);
	}
	
}
