package com.joelkingsley.rmkcet.spas.be.daos;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Batch;
import com.joelkingsley.rmkcet.spas.be.beans.Department;
import com.joelkingsley.rmkcet.spas.be.beans.Exam;
import com.joelkingsley.rmkcet.spas.be.beans.ExamResult;
import com.joelkingsley.rmkcet.spas.be.beans.ExamType;
import com.joelkingsley.rmkcet.spas.be.beans.Semester;
import com.joelkingsley.rmkcet.spas.be.beans.Student;
import com.joelkingsley.rmkcet.spas.be.beans.Subject;
import com.joelkingsley.rmkcet.spas.be.beans.requests.AddExamResultRequest;
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
				
				ExamType examType = new ExamType(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_EXAM_TYPES, DBConstants.COL_EXAM_TYPES_EXAM_TYPE_ID)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_EXAM_TYPES, DBConstants.COL_EXAM_TYPES_EXAM_TYPE_NAME)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_EXAM_TYPES, DBConstants.COL_EXAM_TYPES_ABBREVIATION)));
						
				Subject subject = new Subject(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_SUBJECTS, DBConstants.COL_SUBJECTS_SUBJECT_ID)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_SUBJECTS, DBConstants.COL_SUBJECTS_SUBJECT_CODE)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_SUBJECTS, DBConstants.COL_SUBJECTS_SUBJECT_NAME)),
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_SUBJECTS, DBConstants.COL_SUBJECTS_CREDIT)));
				
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
				
				Exam exam = new Exam(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_EXAMS, DBConstants.COL_EXAMS_EXAM_ID)),
						examType,
						subject,
						semester);
				
				boolean isHosteler = resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_STUDENTS,DBConstants.COL_STUDENTS_IS_HOSTELER)) != 0;
				
				Student student = new Student(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_STUDENTS, DBConstants.COL_STUDENTS_STUDENT_ID)),
						BigInteger.valueOf(resultSet.getLong(String.format("%s.%s", DBConstants.TABLE_STUDENTS, DBConstants.COL_STUDENTS_STUDENT_ID))),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_STUDENTS, DBConstants.COL_STUDENTS_STUDENT_NAME)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_STUDENTS, DBConstants.COL_STUDENTS_GENDER)),
						isHosteler,
						batch,
						department);
				
				ExamResult examResult = new ExamResult(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_EXAM_RESULTS, DBConstants.COL_EXAM_RESULTS_EXAM_RESULT_ID)),
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_EXAM_RESULTS, DBConstants.COL_EXAM_RESULTS_MARKS)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_EXAM_RESULTS, DBConstants.COL_EXAM_RESULTS_GRADE)),
						exam,
						student);
				
				
				examResults.add(examResult);
			}
			return examResults;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.SERVER_ERROR);
		}
	}

	public ArrayList<ExamResult> getAllExamResultsOfRegisterNumber(BigInteger registerNumber) throws AppError {
		Connection connection = DBUtils.getConnection();
		ArrayList<ExamResult> examResults = new ArrayList<ExamResult>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.GET_ALL_EXAM_RESULTS_OF_REGISTER_NUMBER);
			preparedStatement.setLong(1, registerNumber.longValueExact());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				ExamType examType = new ExamType(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_EXAM_TYPES, DBConstants.COL_EXAM_TYPES_EXAM_TYPE_ID)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_EXAM_TYPES, DBConstants.COL_EXAM_TYPES_EXAM_TYPE_NAME)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_EXAM_TYPES, DBConstants.COL_EXAM_TYPES_ABBREVIATION)));
						
				Subject subject = new Subject(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_SUBJECTS, DBConstants.COL_SUBJECTS_SUBJECT_ID)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_SUBJECTS, DBConstants.COL_SUBJECTS_SUBJECT_CODE)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_SUBJECTS, DBConstants.COL_SUBJECTS_SUBJECT_NAME)),
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_SUBJECTS, DBConstants.COL_SUBJECTS_CREDIT)));
				
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
				
				Exam exam = new Exam(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_EXAMS, DBConstants.COL_EXAMS_EXAM_ID)),
						examType,
						subject,
						semester);
				
				boolean isHosteler = resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_STUDENTS,DBConstants.COL_STUDENTS_IS_HOSTELER)) != 0;
				
				Student student = new Student(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_STUDENTS, DBConstants.COL_STUDENTS_STUDENT_ID)),
						BigInteger.valueOf(resultSet.getLong(String.format("%s.%s", DBConstants.TABLE_STUDENTS, DBConstants.COL_STUDENTS_STUDENT_ID))),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_STUDENTS, DBConstants.COL_STUDENTS_STUDENT_NAME)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_STUDENTS, DBConstants.COL_STUDENTS_GENDER)),
						isHosteler,
						batch,
						department);
				
				ExamResult examResult = new ExamResult(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_EXAM_RESULTS, DBConstants.COL_EXAM_RESULTS_EXAM_RESULT_ID)),
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_EXAM_RESULTS, DBConstants.COL_EXAM_RESULTS_MARKS)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_EXAM_RESULTS, DBConstants.COL_EXAM_RESULTS_GRADE)),
						exam,
						student);
				
				
				examResults.add(examResult);
			}
			return examResults;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.SERVER_ERROR);
		}
	}

	public AddExamResultRequest addExamResult(AddExamResultRequest addExamResultRequest) throws AppError {
		Connection connection = DBUtils.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.ADD_EXAM_RESULT, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1,  addExamResultRequest.getExamID());
			preparedStatement.setInt(2, addExamResultRequest.getStudentID());
			preparedStatement.setInt(3, addExamResultRequest.getMarks());
			preparedStatement.setString(4, addExamResultRequest.getGrade());
			
			int affectedRows = preparedStatement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new AppError(ErrorConstants.EXAM_RESULT_NOT_CREATED);
	        }

	        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                addExamResultRequest.setExamResultID(generatedKeys.getInt(1));
	                return addExamResultRequest;
	            }
	            else {
	                throw new AppError(ErrorConstants.EXAM_RESULT_ID_NOT_OBTAINED);
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
