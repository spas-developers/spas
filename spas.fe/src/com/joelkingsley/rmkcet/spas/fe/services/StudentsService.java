package com.joelkingsley.rmkcet.spas.fe.services;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.fe.beans.Student;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddStudentRequest;
import com.joelkingsley.rmkcet.spas.fe.delegates.StudentsDelegate;

public class StudentsService {

	StudentsDelegate studentsDelegate;

	public StudentsService() {
		super();
		this.studentsDelegate = new StudentsDelegate();
	}
		
	public ArrayList<Student> getAllStudents() {
		return studentsDelegate.getAllStudents();
	}
	
	public AddStudentRequest addStudent(AddStudentRequest addStudentRequest) {
		return studentsDelegate.addStudent(addStudentRequest);
	}
	
}
