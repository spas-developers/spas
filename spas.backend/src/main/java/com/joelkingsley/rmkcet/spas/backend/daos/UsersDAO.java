package com.joelkingsley.rmkcet.spas.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.backend.beans.User;
import com.joelkingsley.rmkcet.spas.backend.beans.UserType;
import com.joelkingsley.rmkcet.spas.backend.beans.schema.UserTypesSchema;
import com.joelkingsley.rmkcet.spas.backend.beans.schema.UsersSchema;
import com.joelkingsley.rmkcet.spas.backend.constants.Queries;
import com.joelkingsley.rmkcet.spas.backend.utils.DBUtils;
import com.joelkingsley.rmkcet.spas.backend.utils.PersistenceException;

public class UsersDAO {

	public ArrayList<User> getAllUsers() throws PersistenceException {
		Connection connection = DBUtils.getConnection();
		ArrayList<User> users = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_ALL_USERS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserType userType = new UserType(
						resultSet.getInt(UserTypesSchema.COL_USER_TYPE_ID),
						resultSet.getString(UsersSchema.COL_NAME));
				
				User user = new User(
						resultSet.getInt(UsersSchema.COL_USER_ID),
						resultSet.getString(UsersSchema.COL_NAME),
						resultSet.getString(UsersSchema.COL_EMAIL),
						resultSet.getString(UsersSchema.COL_PASSWORD),
						userType);
				
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Error in getAllUsers");
		}
	}
	
}
