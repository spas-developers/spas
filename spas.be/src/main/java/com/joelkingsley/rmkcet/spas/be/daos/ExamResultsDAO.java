package com.joelkingsley.rmkcet.spas.be.daos;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Batch;
import com.joelkingsley.rmkcet.spas.be.beans.Department;
import com.joelkingsley.rmkcet.spas.be.beans.ExamResult;
import com.joelkingsley.rmkcet.spas.be.beans.ExamType;
import com.joelkingsley.rmkcet.spas.be.beans.Student;
import com.joelkingsley.rmkcet.spas.be.constants.DBConstants;
import com.joelkingsley.rmkcet.spas.be.constants.DBQueries;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;
import com.joelkingsley.rmkcet.spas.be.utils.DBUtils;

public class ExamResultsDAO {

	public ArrayList<ExamResult> getAllExamResults() throws AppError {
		Connection connection = DBUtils.getConnection();
		ArrayList<ExamResult> examResults = new ArrayList<ExamResult>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.GET_ALL_EXAM_RESULTS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				Exam exam = new Exam(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_BATCHES, DBConstants.COL_BATCHES_BATCH_ID)),
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_BATCHES, DBConstants.COL_BATCHES_BATCH_START_YEAR)));
						
				ExamType examType = new ExamType(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_EXAM_TYPE, DBConstants.COL_EXAM_TYPES_EXAM_TYPE_ID)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_EXAM_TYPE, DBConstants.COL_EXAM_TYPES_EXAM_TYPE_NAME)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_EXAM_TYPE, DBConstants.COL_EXAM_TYPES_ABBREVIATION)));
				
				ExamResult examResult = new ExamResult(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_EXAM_RESULT, DBConstants.COL_EXAM_RESULTS_EXAM_RESULT_ID)),
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_EXAM_RESULT, DBConstants.COL_EXAM_RESULTS_MARKS)),
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_EXAM_RESULT, DBConstants.COL_EXAM_RESULTS_GRADE)),
						exam,
						examType);
				
				
				examResults.add(examResult);
			}
			return examResults;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.SERVER_ERROR);
		}
	}
	
}
