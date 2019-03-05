package com.joelkingsley.rmkcet.spas.be.delegates;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Department;
import com.joelkingsley.rmkcet.spas.be.daos.DepartmentsDAO;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

public class DepartmentsDelegate {

	DepartmentsDAO departmentsDAO;
	
	public DepartmentsDelegate() {
		super();
		departmentsDAO = new DepartmentsDAO();
	}

	public ArrayList<Department> getAllDepartments() throws AppError {
		try {
			return departmentsDAO.getAllDepartments();
		} catch (AppError e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
