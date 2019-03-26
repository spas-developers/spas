package com.joelkingsley.rmkcet.spas.be.delegates;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.User;
import com.joelkingsley.rmkcet.spas.be.beans.requests.AddExamRequest;
import com.joelkingsley.rmkcet.spas.be.beans.requests.AddUserRequest;
import com.joelkingsley.rmkcet.spas.be.daos.UsersDAO;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

public class UsersDelegate {

	UsersDAO usersDAO = new UsersDAO();
	
	public UsersDelegate() {
		super();
	}

	public ArrayList<User> getAllUsers() throws AppError {
		try {
			System.out.println(" DELEGATE ");
			return usersDAO.getAllUsers();
		} catch (AppError e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public AddUserRequest addUser(AddUserRequest addUserRequest) throws AppError {
		try {
			return usersDAO.addUser(addUserRequest);
		} catch (AppError e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
