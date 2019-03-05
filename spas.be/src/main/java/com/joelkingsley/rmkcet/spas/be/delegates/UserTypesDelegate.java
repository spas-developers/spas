package com.joelkingsley.rmkcet.spas.be.delegates;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.UserType;
import com.joelkingsley.rmkcet.spas.be.daos.UserTypesDAO;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

public class UserTypesDelegate {

UserTypesDAO userTypesDAO;
	
	public UserTypesDelegate() {
		super();
		userTypesDAO = new UserTypesDAO();
	}

	public ArrayList<UserType> getAllUserTypes() throws AppError {
		try {
			return userTypesDAO.getAllUserTypes();
		} catch (AppError e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
