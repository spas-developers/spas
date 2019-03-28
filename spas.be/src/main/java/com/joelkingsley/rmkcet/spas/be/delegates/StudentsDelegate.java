package com.joelkingsley.rmkcet.spas.be.delegates;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Student;
import com.joelkingsley.rmkcet.spas.be.beans.requests.AddStudentRequest;
import com.joelkingsley.rmkcet.spas.be.daos.StudentsDAO;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

public class StudentsDelegate {
StudentsDAO studentsDAO;
	
	public StudentsDelegate() {
		super();
		studentsDAO = new StudentsDAO();
	}

	public ArrayList<Student> getAllStudents() throws AppError {
		try {
			return studentsDAO.getAllStudents();
		} catch (AppError e) {
			e.printStackTrace();
			throw e;
		}
	}

	public AddStudentRequest addStudent(AddStudentRequest addStudentRequest) throws AppError {
		try {
			return studentsDAO.addStudent(addStudentRequest);
		} catch (AppError e) {
			e.printStackTrace();
			throw e;
		}
	}
	

}
