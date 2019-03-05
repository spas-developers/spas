package com.joelkingsley.rmkcet.spas.be.delegates;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Semester;
import com.joelkingsley.rmkcet.spas.be.daos.SemestersDAO;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

public class SemestersDelegate {

SemestersDAO semestersDAO;
	
	public SemestersDelegate() {
		super();
		semestersDAO = new SemestersDAO();
	}

	public ArrayList<Semester> getAllSemesters() throws AppError {
		try {
			return semestersDAO.getAllSemesters();
		} catch (AppError e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
