package com.joelkingsley.rmkcet.spas.be.delegates;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Subject;
import com.joelkingsley.rmkcet.spas.be.daos.SubjectsDAO;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

public class SubjectsDelegate {

SubjectsDAO subjectsDAO;
	
	public SubjectsDelegate() {
		super();
		subjectsDAO = new SubjectsDAO();
	}

	public ArrayList<Subject> getAllSubjects() throws AppError {
		try {
			return subjectsDAO.getAllSubjects();
		} catch (AppError e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Subject getSubjectOfSubjectCode(String subjectCode) throws AppError {
		try {
			return subjectsDAO.getSubjectOfSubjectCode(subjectCode);
		} catch (AppError e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}