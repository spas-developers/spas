package com.joelkingsley.rmkcet.spas.fe.delegates;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joelkingsley.rmkcet.spas.fe.beans.ExamType;
import com.joelkingsley.rmkcet.spas.fe.beans.Subject;
import com.joelkingsley.rmkcet.spas.fe.utils.RestCaller;

public class ExamTypesDelegate {

	public ArrayList<ExamType> getAllExamTypes() {
		ArrayList<ExamType> examTypes = null;
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		try {
			json = restCaller.doGet("http://localhost:8080/examTypes/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<ExamType>>() {}.getType();
		System.out.println(json);
		examTypes = gson.fromJson(json, type);
		
		return examTypes;
	}

	public ExamType addExamType(ExamType examType) {
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		Gson gson = new Gson();
		Type type = new TypeToken<Subject>() {}.getType();
		json = restCaller.doPost("http://localhost:8080/examTypes/",  gson.toJson(examType, type));
		System.out.println(json);
		
		return gson.fromJson(json, type);
		
	}
	
}
