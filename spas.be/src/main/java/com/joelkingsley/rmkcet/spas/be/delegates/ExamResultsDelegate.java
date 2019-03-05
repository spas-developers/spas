package com.joelkingsley.rmkcet.spas.be.delegates;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.ExamResult;
import com.joelkingsley.rmkcet.spas.be.daos.ExamResultsDAO;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

public class ExamResultsDelegate {

ExamResultsDAO examResultsDAO;
	
	public ExamResultsDelegate() {
		super();
		examResultsDAO = new ExamResultsDAO();
	}

	public ArrayList<ExamResult> getAllExamResults() throws AppError {
		try {
			return examResultsDAO.getAllExamResults();
		} catch (AppError e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
