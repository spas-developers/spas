package com.joelkingsley.rmkcet.spas.be.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joelkingsley.rmkcet.spas.be.beans.UserType;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.delegates.UserTypesDelegate;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

@RestController
public class UserTypesController {

UserTypesDelegate userTypesDelegate;

	public UserTypesController() {
		super();
		this.userTypesDelegate = new UserTypesDelegate();
	}

	@GetMapping("usertypes")
	ResponseEntity<?> getAllUserTypes() {
		try {
			System.out.println( "User Types" );
			ArrayList<UserType> userTypes = userTypesDelegate.getAllUserTypes();
			if(userTypes == null) {
				ResponseEntity<String> responseEntity = new ResponseEntity<String>(ErrorConstants.USER_TYPES_NOT_FOUND, HttpStatus.NOT_FOUND);
				return responseEntity;
			} else {
				ResponseEntity<ArrayList<UserType>> responseEntity = new ResponseEntity<ArrayList<UserType>>(userTypes, HttpStatus.FOUND);
				return responseEntity;
			}
		} catch (AppError appError) {
			appError.getException().printStackTrace();
			ResponseEntity<String> responseEntity = new ResponseEntity<String>(appError.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return responseEntity;
		}
	}
	
}
