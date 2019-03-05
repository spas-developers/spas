package com.joelkingsley.rmkcet.spas.be.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Batch;
import com.joelkingsley.rmkcet.spas.be.beans.Department;
import com.joelkingsley.rmkcet.spas.be.beans.Semester;
import com.joelkingsley.rmkcet.spas.be.constants.DBConstants;
import com.joelkingsley.rmkcet.spas.be.constants.DBQueries;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;
import com.joelkingsley.rmkcet.spas.be.utils.DBUtils;

public class SemestersDAO {

	public ArrayList<Semester> getAllSemesters() throws AppError {
		Connection connection = DBUtils.getConnection();
		ArrayList<Semester> semesters = new ArrayList<Semester>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.GET_ALL_SEMESTERS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				Batch batch = new Batch(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_BATCHES, DBConstants.COL_BATCHES_BATCH_ID)),
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_BATCHES, DBConstants.COL_BATCHES_BATCH_START_YEAR)));
				
				Department department = new Department(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_DEPARTMENTS, DBConstants.COL_DEPARTMENTS_DEPARTMENT_ID)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_DEPARTMENTS, DBConstants.COL_DEPARTMENTS_DEPARTMENT_NAME)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_DEPARTMENTS, DBConstants.COL_DEPARTMENTS_ABBREVIATION)));
				
				Semester semester = new Semester(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_SEMESTERS, DBConstants.COL_SEMESTERS_SEMESTER_ID)),
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_SEMESTERS, DBConstants.COL_SEMESTERS_SEMESTER_NUMBER)),
						batch,
						department);
				
				semesters.add(semester);
			}
			return semesters;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.SERVER_ERROR);
		}
	}
	
}