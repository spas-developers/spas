package com.joelkingsley.rmkcet.spas.fe.services;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.fe.beans.Department;
import com.joelkingsley.rmkcet.spas.fe.delegates.DepartmentsDelegate;

public class DepartmentsService {

DepartmentsDelegate departmentsDelegate;
	
	public DepartmentsService() {
		super();
		departmentsDelegate = new DepartmentsDelegate();
	}
	
	public ArrayList<Department> getAllDepartments() {
		return departmentsDelegate.getAllDepartments();
	}
	
	public Department addDepartment(Department department) {
		return departmentsDelegate.addDepartment(department);
	}
	
}
