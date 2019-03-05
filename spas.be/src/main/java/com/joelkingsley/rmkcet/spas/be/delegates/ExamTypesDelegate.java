package com.joelkingsley.rmkcet.spas.be.delegates;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.ExamType;
import com.joelkingsley.rmkcet.spas.be.daos.ExamTypesDAO;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

	public class ExamTypesDelegate {
		ExamTypesDAO examTypesDAO;
			
			public ExamTypesDelegate() {
				super();
				examTypesDAO = new ExamTypesDAO();
			}

			public ArrayList<ExamType> getAllExamTypes() throws AppError {
				try {
					return examTypesDAO.getAllExamTypes();
				} catch (AppError e) {
					e.printStackTrace();
					throw e;
				}
			}
			

}
