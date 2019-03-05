package com.joelkingsley.rmkcet.spas.be.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.joelkingsley.rmkcet.spas.be.beans.Exam;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.delegates.ExamsDelegate;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

public class ExamsController {
	
ExamsDelegate examsDelegate;
	
	public ExamsController() {
		super();
		this.examsDelegate = new ExamsDelegate();
	}

	@GetMapping("/exams")
	ResponseEntity<?> getAllExams() {
		try {
			ArrayList<Exam> exams = examsDelegate.getAllExams();
			if(exams.size() == 0) {
				ResponseEntity<String> responseEntity = new ResponseEntity<String>(ErrorConstants.EXAMS_NOT_FOUND, HttpStatus.NOT_FOUND);
				return responseEntity;
			} else {
				ResponseEntity<ArrayList<Exam>> responseEntity = new ResponseEntity<ArrayList<Exam>>(exams, HttpStatus.FOUND);
				return responseEntity;
			}
		} catch (AppError appError) {
			appError.getException().printStackTrace();
			ResponseEntity<String> responseEntity = new ResponseEntity<String>(appError.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return responseEntity;
		}
	}

}
