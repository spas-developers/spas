package com.joelkingsley.rmkcet.spas.be.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Subject;
import com.joelkingsley.rmkcet.spas.be.constants.DBConstants;
import com.joelkingsley.rmkcet.spas.be.constants.DBQueries;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;
import com.joelkingsley.rmkcet.spas.be.utils.DBUtils;

public class SubjectsDAO {

	public ArrayList<Subject> getAllSubjects() throws AppError {
		Connection connection = DBUtils.getConnection();
		ArrayList<Subject> subjects = new ArrayList<Subject>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.GET_ALL_SUBJECTS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Subject subject = new Subject(
						resultSet.getInt(DBConstants.COL_SUBJECTS_SUBJECT_ID),
						resultSet.getString(DBConstants.COL_SUBJECTS_SUBJECT_CODE),
						resultSet.getString(DBConstants.COL_SUBJECTS_SUBJECT_NAME),
						resultSet.getInt(DBConstants.COL_SUBJECTS_CREDIT));
				
				subjects.add(subject);
			}
			return subjects;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.SERVER_ERROR);
		}
	}

	public Subject getSubjectOfSubjectCode(String subjectCode) throws AppError {
		Connection connection = DBUtils.getConnection();


		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.GET_SUBJECT);
			preparedStatement.setString(1, subjectCode);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			System.out.println(preparedStatement.toString());
			
			Subject subject =  null;

			while (resultSet.next()) {
						subject = new Subject (resultSet.getInt(DBConstants.COL_SUBJECTS_SUBJECT_ID),
						resultSet.getString(DBConstants.COL_SUBJECTS_SUBJECT_CODE),
						resultSet.getString(DBConstants.COL_SUBJECTS_SUBJECT_NAME),
						resultSet.getInt(DBConstants.COL_SUBJECTS_CREDIT));
						System.out.println(subject.toString());
				
			}
			System.out.println(subject.toString());
			return subject;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.SERVER_ERROR);
		}
	
	}

	public Subject addSubject(Subject subject) throws AppError {


		Connection connection = DBUtils.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.ADD_SUBJECT, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, subject.getSubjectCode());
			preparedStatement.setString(2, subject.getSubjectName());
			preparedStatement.setInt(3, subject.getCredit());

			int affectedRows = preparedStatement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new AppError(ErrorConstants.SUBJECT_NOT_CREATED);
	        }

	        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                subject.setSubjectID(generatedKeys.getInt(1));
	                return subject;
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
