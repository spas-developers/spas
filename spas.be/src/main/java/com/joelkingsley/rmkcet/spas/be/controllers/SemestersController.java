package com.joelkingsley.rmkcet.spas.be.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joelkingsley.rmkcet.spas.be.beans.Semester;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.delegates.SemestersDelegate;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

@RestController
public class SemestersController {

SemestersDelegate semestersDelegate;
	
	public SemestersController() {
		super();
		this.semestersDelegate = new SemestersDelegate();
	}



	@GetMapping("/semesters")
	ResponseEntity<?> getAllSemesters() {
		try {
			ArrayList<Semester> semesters = semestersDelegate.getAllSemesters();
			if(semesters.size() == 0) {
				ResponseEntity<String> responseEntity = new ResponseEntity<String>(ErrorConstants.SEMESTERS_NOT_FOUND, HttpStatus.NOT_FOUND);
				return responseEntity;
			} else {
				ResponseEntity<ArrayList<Semester>> responseEntity = new ResponseEntity<ArrayList<Semester>>(semesters, HttpStatus.FOUND);
				return responseEntity;
			}
		} catch (AppError appError) {
			appError.getException().printStackTrace();
			ResponseEntity<String> responseEntity = new ResponseEntity<String>(appError.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return responseEntity;
		}
	}
	
}
