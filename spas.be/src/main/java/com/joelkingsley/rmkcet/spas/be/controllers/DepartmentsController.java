package com.joelkingsley.rmkcet.spas.be.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joelkingsley.rmkcet.spas.be.beans.Department;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.delegates.DepartmentsDelegate;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

@RestController
public class DepartmentsController {
	
	DepartmentsDelegate departmentsDelegate;
	
	public DepartmentsController() {
		super();
		this.departmentsDelegate = new DepartmentsDelegate();
	}



	@GetMapping("/departments")
	ResponseEntity<?> getAllDepartments() {
		try {
			ArrayList<Department> departments = departmentsDelegate.getAllDepartments();
			if(departments.size() == 0) {
				ResponseEntity<String> responseEntity = new ResponseEntity<String>(ErrorConstants.DEPARTMENTS_NOT_FOUND, HttpStatus.NOT_FOUND);
				return responseEntity;
			} else {
				ResponseEntity<ArrayList<Department>> responseEntity = new ResponseEntity<ArrayList<Department>>(departments, HttpStatus.FOUND);
				return responseEntity;
			}
		} catch (AppError appError) {
			appError.getException().printStackTrace();
			ResponseEntity<String> responseEntity = new ResponseEntity<String>(appError.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return responseEntity;
		}
	}
}
