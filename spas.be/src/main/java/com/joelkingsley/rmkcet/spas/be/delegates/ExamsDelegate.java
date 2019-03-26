package com.joelkingsley.rmkcet.spas.be.delegates;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Exam;
import com.joelkingsley.rmkcet.spas.be.beans.requests.AddExamRequest;
import com.joelkingsley.rmkcet.spas.be.daos.ExamsDAO;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

public class ExamsDelegate {
ExamsDAO examsDAO;
	
	public ExamsDelegate() {
		super();
		examsDAO = new ExamsDAO();
	}

	public ArrayList<Exam> getAllExams() throws AppError {
		try {
			return examsDAO.getAllExams();
		} catch (AppError e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public AddExamRequest addExam(AddExamRequest addExamRequest) throws AppError {
		try {
			return examsDAO.addExam(addExamRequest);
		} catch (AppError e) {
			e.printStackTrace();
			throw e;
		}
	}

}
