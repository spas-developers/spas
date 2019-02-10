package com.joelkingsley.rmkcet.spas.backend.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.joelkingsley.rmkcet.spas.backend.constants.DBConstants;
import com.joelkingsley.rmkcet.spas.backend.constants.ErrorConstants;

public class DBUtils {
	public static Connection getConnection() throws PersistenceException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection;
			connection = DriverManager.getConnection(DBConstants.DRIVER_URL,DBConstants.DRIVER_USERNAME,DBConstants.DRIVER_PASSWORD);
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException(ErrorConstants.ERROR_CONNECTION_OPENING,e);
		}
	}
	
	public static void closeConnection(Connection connection) throws PersistenceException {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new PersistenceException(ErrorConstants.ERROR_CONNECTION_CLOSING,e);
		}
	}

	public static void closeConnection(Connection connection, ResultSet rs) throws PersistenceException {
		try {
			connection.close();
			rs.close();
		} catch (SQLException e) {
			throw new PersistenceException(ErrorConstants.ERROR_CONNECTION_CLOSING,e);
		}
	}
}
