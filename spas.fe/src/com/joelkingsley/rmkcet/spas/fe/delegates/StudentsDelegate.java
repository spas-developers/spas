package com.joelkingsley.rmkcet.spas.fe.delegates;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joelkingsley.rmkcet.spas.fe.beans.Student;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddStudentRequest;
import com.joelkingsley.rmkcet.spas.fe.utils.RestCaller;

public class StudentsDelegate {

	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> students = null;
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		try {
			json = restCaller.doGet("http://localhost:8080/students/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Student>>() {}.getType();
		System.out.println(json);
		students = gson.fromJson(json, type);
		
		return students;
	}

	public AddStudentRequest addStudent(AddStudentRequest addStudentRequest) {
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		Gson gson = new Gson();
		Type type = new TypeToken<AddStudentRequest>() {}.getType();
		json = restCaller.doPost("http://localhost:8080/students/",  gson.toJson(addStudentRequest, type));
		System.out.println(json);
		
		return gson.fromJson(json, type);
	}
	
}
