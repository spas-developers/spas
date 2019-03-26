package com.joelkingsley.rmkcet.spas.be.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joelkingsley.rmkcet.spas.be.beans.Student;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.delegates.StudentsDelegate;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

@RestController
public class StudentsController {
	
	StudentsDelegate studentsDelegate;
	
	public StudentsController() {
		super();
		this.studentsDelegate = new StudentsDelegate();
	}

	@GetMapping("/students")
	ResponseEntity<?> getAllStudents() {
		try {
			ArrayList<Student> students = studentsDelegate.getAllStudents();
			if(students.size() == 0) {
				ResponseEntity<String> responseEntity = new ResponseEntity<String>(ErrorConstants.STUDENTS_NOT_FOUND, HttpStatus.NOT_FOUND);
				return responseEntity;
			} else {
				ResponseEntity<ArrayList<Student>> responseEntity = new ResponseEntity<ArrayList<Student>>(students, HttpStatus.FOUND);
				return responseEntity;
			}
		} catch (AppError appError) {
			appError.getException().printStackTrace();
			ResponseEntity<String> responseEntity = new ResponseEntity<String>(appError.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return responseEntity;
		}
	}

}
