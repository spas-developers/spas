package com.joelkingsley.rmkcet.spas.be.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.ExamType;
import com.joelkingsley.rmkcet.spas.be.constants.DBConstants;
import com.joelkingsley.rmkcet.spas.be.constants.DBQueries;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;
import com.joelkingsley.rmkcet.spas.be.utils.DBUtils;

public class ExamTypesDAO {
	public ArrayList<ExamType> getAllExamTypes() throws AppError {
		Connection connection = DBUtils.getConnection();
		ArrayList<ExamType> examTypes = new ArrayList<ExamType>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.GET_ALL_EXAM_TYPES);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ExamType examType = new ExamType(
						resultSet.getInt(DBConstants.COL_EXAM_TYPES_EXAM_TYPE_ID),
						resultSet.getString(DBConstants.COL_EXAM_TYPES_EXAM_TYPE_NAME),
						resultSet.getString(DBConstants.COL_EXAM_TYPES_ABBREVIATION));
				
				examTypes.add(examType);
			}
			return examTypes;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.EXAM_TYPES_NOT_FOUND, sqlException);
		}
	}

}
