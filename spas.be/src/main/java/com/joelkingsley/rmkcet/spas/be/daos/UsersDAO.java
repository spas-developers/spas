package com.joelkingsley.rmkcet.spas.be.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Batch;
import com.joelkingsley.rmkcet.spas.be.beans.Department;
import com.joelkingsley.rmkcet.spas.be.beans.User;
import com.joelkingsley.rmkcet.spas.be.beans.UserType;
import com.joelkingsley.rmkcet.spas.be.beans.requests.AddUserRequest;
import com.joelkingsley.rmkcet.spas.be.constants.DBConstants;
import com.joelkingsley.rmkcet.spas.be.constants.DBQueries;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;
import com.joelkingsley.rmkcet.spas.be.utils.DBUtils;

public class UsersDAO {

	public ArrayList<User> getAllUsers() throws AppError {
		Connection connection = DBUtils.getConnection();
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.GET_ALL_USERS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				UserType userType = new UserType(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_USER_TYPES, DBConstants.COL_USER_TYPES_USER_TYPE_ID)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_USER_TYPES, DBConstants.COL_USER_TYPES_NAME)));
				
				Department department = new Department(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_DEPARTMENTS, DBConstants.COL_DEPARTMENTS_DEPARTMENT_ID)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_DEPARTMENTS, DBConstants.COL_DEPARTMENTS_DEPARTMENT_NAME)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_DEPARTMENTS, DBConstants.COL_DEPARTMENTS_ABBREVIATION)));
				
				User user = new User(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_USERS, DBConstants.COL_USERS_USER_ID)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_USERS, DBConstants.COL_USERS_NAME)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_USERS, DBConstants.COL_USERS_EMAIL)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_USERS, DBConstants.COL_USERS_PASSWORD)),
						userType,
						department);
				
				users.add(user);
			}
			return users;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.SERVER_ERROR);
		}
	}
	
	public User addUser(AddUserRequest addUserRequest) throws AppError {
		Connection connection = DBUtils.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.ADD_USER, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, addUserRequest.);
			int affectedRows = preparedStatement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new AppError(ErrorConstants.BATCH_NOT_CREATED);
	        }

	        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                batch.setBatchID(generatedKeys.getInt(1));
	                return batch;
	            }
	            else {
	                throw new AppError(ErrorConstants.BATCH_ID_NOT_OBTAINED);
	            }
	        }
			
		} catch (SQLIntegrityConstraintViolationException exception) {
			exception.printStackTrace();
			throw new AppError(ErrorConstants.DUPLICATE_ENTRY, exception);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.SERVER_ERROR, sqlException);
		} catch (AppError appError) {
			throw appError;
		}
	}
	
}
