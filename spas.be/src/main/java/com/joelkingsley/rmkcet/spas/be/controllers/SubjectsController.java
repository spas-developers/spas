package com.joelkingsley.rmkcet.spas.be.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.joelkingsley.rmkcet.spas.be.beans.Subject;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.delegates.SubjectsDelegate;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

@RestController
public class SubjectsController {

SubjectsDelegate subjectsDelegate;
	
	public SubjectsController() {
		super();
		this.subjectsDelegate = new SubjectsDelegate();
	}



	@GetMapping("/subjects")
	ResponseEntity<?> getAllSubjects() {
		try {
			ArrayList<Subject> subjects = subjectsDelegate.getAllSubjects();
			if(subjects.size() == 0) {
				ResponseEntity<String> responseEntity = new ResponseEntity<String>(ErrorConstants.SUBJECTS_NOT_FOUND, HttpStatus.NOT_FOUND);
				return responseEntity;
			} else {
				ResponseEntity<ArrayList<Subject>> responseEntity = new ResponseEntity<ArrayList<Subject>>(subjects, HttpStatus.FOUND);
				return responseEntity;
			}
		} catch (AppError appError) {
			appError.getException().printStackTrace();
			ResponseEntity<String> responseEntity = new ResponseEntity<String>(appError.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return responseEntity;
		}
	}
	


@GetMapping("/subjects/{subjectCode}")
ResponseEntity<?> getAllExamResultsOfsubjectCode(@PathVariable String subjectCode) {
	try {
		Subject subject = subjectsDelegate.getSubjectOfSubjectCode(subjectCode);
		if(subject == null) {
			ResponseEntity<String> responseEntity = new ResponseEntity<String>(ErrorConstants.SUBJECTS_NOT_FOUND, HttpStatus.NOT_FOUND);
			return responseEntity;
		} else {
			ResponseEntity<Subject> responseEntity = new ResponseEntity<Subject>(subject, HttpStatus.FOUND);
			return responseEntity;
		}
	} catch (AppError appError) {
		appError.getException().printStackTrace();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(appError.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
	}
}

}

