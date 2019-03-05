package com.joelkingsley.rmkcet.spas.be.daos;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Batch;
import com.joelkingsley.rmkcet.spas.be.beans.Department;
import com.joelkingsley.rmkcet.spas.be.beans.Student;
import com.joelkingsley.rmkcet.spas.be.constants.DBConstants;
import com.joelkingsley.rmkcet.spas.be.constants.DBQueries;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;
import com.joelkingsley.rmkcet.spas.be.utils.DBUtils;

public class StudentsDAO {
	public ArrayList<Student> getAllStudents() throws AppError {
		Connection connection = DBUtils.getConnection();
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.GET_ALL_STUDENTS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				Batch batch=new Batch(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_BATCHES, DBConstants.COL_BATCHES_BATCH_ID)),
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_BATCHES, DBConstants.COL_BATCHES_BATCH_START_YEAR)));
						
				Department department = new Department(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_DEPARTMENTS, DBConstants.COL_DEPARTMENTS_DEPARTMENT_ID)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_DEPARTMENTS, DBConstants.COL_DEPARTMENTS_DEPARTMENT_NAME)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_DEPARTMENTS, DBConstants.COL_DEPARTMENTS_ABBREVIATION)));
				
				boolean isHosteler = resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_STUDENTS,DBConstants.COL_STUDENTS_IS_HOSTELER)) != 0;
				
				Student student = new Student(
						resultSet.getInt(String.format("%s.%s", DBConstants.TABLE_STUDENTS, DBConstants.COL_STUDENTS_STUDENT_ID)),
						BigInteger.valueOf(resultSet.getLong(String.format("%s.%s", DBConstants.TABLE_STUDENTS,DBConstants.COL_STUDENTS_REGISTER_NUMBER))),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_STUDENTS,DBConstants.COL_STUDENTS_STUDENT_NAME)),
						resultSet.getString(String.format("%s.%s", DBConstants.TABLE_STUDENTS,DBConstants.COL_STUDENTS_GENDER)),
						isHosteler,
						batch,
						department);
				
				
				students.add(student);
			}
			return students;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.SERVER_ERROR);
		}
	}

}
