package com.joelkingsley.rmkcet.spas.be.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			throw new AppError(ErrorConstants.SUBJECTS_NOT_FOUND);
		}
	}
	
}
