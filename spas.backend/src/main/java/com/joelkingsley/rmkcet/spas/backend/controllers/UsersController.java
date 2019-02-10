package com.joelkingsley.rmkcet.spas.backend.controllers;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joelkingsley.rmkcet.spas.backend.beans.User;
import com.joelkingsley.rmkcet.spas.backend.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.backend.delegates.UsersDelegate;
import com.joelkingsley.rmkcet.spas.backend.utils.PersistenceException;

@RestController
public class UsersController {

	UsersDelegate usersDelegate;
	
	private final static Logger LOGGER = Logger.getLogger(UsersController.class.getName());
	
	public UsersController() {
		super();
		
		this.usersDelegate = new UsersDelegate();
	}



	@RequestMapping(value="/users",method=RequestMethod.GET)
	ResponseEntity<?> getAllUsers() {		
		try {
			ArrayList<User> users = usersDelegate.getAllUsers();
			if (users == null) {
				ResponseEntity<String> responseEntity = new ResponseEntity<String>(ErrorConstants.USERS_NOT_FOUND, HttpStatus.NOT_FOUND);
				return responseEntity;
			} else {
				ResponseEntity<ArrayList<User>> responseEntity = new ResponseEntity<ArrayList<User>>(users, HttpStatus.OK);
				return responseEntity;
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, e.getMessage());
			ResponseEntity<String> responseEntity = new ResponseEntity<String>(ErrorConstants.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
			return responseEntity;
		}
	}
}
