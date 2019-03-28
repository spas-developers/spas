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
import com.joelkingsley.rmkcet.spas.be.beans.Semester;
import com.joelkingsley.rmkcet.spas.be.beans.requests.AddSemesterRequest;
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

	public AddSemesterRequest addSemester(AddSemesterRequest addSemesterRequest) throws AppError {


		Connection connection = DBUtils.getConnection();
		
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.ADD_SEMESTER, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, addSemesterRequest.getSemesterNumber());
			preparedStatement.setInt(2,  addSemesterRequest.getBatchID());
			preparedStatement.setInt(3,  addSemesterRequest.getDepartmentID());


			
			int affectedRows = preparedStatement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new AppError(ErrorConstants.EXAM_NOT_CREATED);
	        }

	        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                addSemesterRequest.setSemesterID(generatedKeys.getInt(1));
	                return addSemesterRequest;
	            }
	            else {
	                throw new AppError(ErrorConstants.EXAM_ID_NOT_OBTAINED);
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
