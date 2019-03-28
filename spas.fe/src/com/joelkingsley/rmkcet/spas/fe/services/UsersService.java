package com.joelkingsley.rmkcet.spas.fe.services;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.fe.beans.User;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddUserRequest;
import com.joelkingsley.rmkcet.spas.fe.delegates.UsersDelegate;

public class UsersService {

	UsersDelegate usersDelegate;

	public UsersService() {
		super();
		this.usersDelegate = new UsersDelegate();
	}
		
	public ArrayList<User> getAllUsers() {
		return usersDelegate.getAllUsers();
	}
	
	public AddUserRequest addUser(AddUserRequest addUserRequest) {
		return usersDelegate.addUser(addUserRequest);
	}
	
}
