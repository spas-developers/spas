package com.joelkingsley.rmkcet.spas.be.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.UserType;
import com.joelkingsley.rmkcet.spas.be.constants.DBConstants;
import com.joelkingsley.rmkcet.spas.be.constants.DBQueries;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;
import com.joelkingsley.rmkcet.spas.be.utils.DBUtils;

public class UserTypesDAO {

	public ArrayList<UserType> getAllUserTypes() throws AppError {
		Connection connection = DBUtils.getConnection();
		ArrayList<UserType> userTypes = new ArrayList<UserType>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.GET_ALL_USER_TYPES);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserType userType = new UserType(
						resultSet.getInt(DBConstants.COL_USER_TYPES_USER_TYPE_ID),
						resultSet.getString(DBConstants.COL_USER_TYPES_NAME));
				
				userTypes.add(userType);
			}
			return userTypes;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.USER_TYPES_NOT_FOUND);
		}
	}
	
}
