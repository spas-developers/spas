package com.joelkingsley.rmkcet.spas.be.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Department;
import com.joelkingsley.rmkcet.spas.be.constants.DBConstants;
import com.joelkingsley.rmkcet.spas.be.constants.DBQueries;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;
import com.joelkingsley.rmkcet.spas.be.utils.DBUtils;

public class DepartmentsDAO {

	public ArrayList<Department> getAllDepartments() throws AppError {
		Connection connection = DBUtils.getConnection();
		ArrayList<Department> departments = new ArrayList<Department>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.GET_ALL_DEPARTMENTS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Department department = new Department(
						resultSet.getInt(DBConstants.COL_DEPARTMENTS_DEPARTMENT_ID),
						resultSet.getString(DBConstants.COL_DEPARTMENTS_DEPARTMENT_NAME),
						resultSet.getString(DBConstants.COL_DEPARTMENTS_ABBREVIATION));
				
				departments.add(department);
			}
			return departments;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.SERVER_ERROR);
		}
	}

	public Department addDepartment(Department department) throws AppError {
		Connection connection = DBUtils.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.ADD_DEPARTMENT, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, department.getDepartmentName());
			preparedStatement.setString(2, department.getAbbreviation());

			
			int affectedRows = preparedStatement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new AppError(ErrorConstants.DEPARTMENT_NOT_CREATED);
	        }

	        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                department.setDepartmentID(generatedKeys.getInt(1));
	                return department;
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
