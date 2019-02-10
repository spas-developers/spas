package com.joelkingsley.rmkcet.spas.backend.delegates;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.backend.beans.User;
import com.joelkingsley.rmkcet.spas.backend.daos.UsersDAO;
import com.joelkingsley.rmkcet.spas.backend.utils.PersistenceException;

public class UsersDelegate {
	public ArrayList<User> getAllUsers() throws PersistenceException {
		UsersDAO usersDAO = new UsersDAO();
		return usersDAO.getAllUsers();
	}
}
