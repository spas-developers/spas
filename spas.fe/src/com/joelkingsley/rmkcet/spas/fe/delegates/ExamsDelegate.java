package com.joelkingsley.rmkcet.spas.fe.delegates;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joelkingsley.rmkcet.spas.fe.beans.Exam;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddExamRequest;
import com.joelkingsley.rmkcet.spas.fe.utils.RestCaller;

public class ExamsDelegate {

	public ArrayList<Exam> getAllExams() {
		ArrayList<Exam> exams = null;
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		try {
			json = restCaller.doGet("http://localhost:8080/exams/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Exam>>() {}.getType();
		System.out.println(json);
		exams = gson.fromJson(json, type);
		
		return exams;
	}

	public AddExamRequest addExam(AddExamRequest addExamRequest) {
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		Gson gson = new Gson();
		Type type = new TypeToken<AddExamRequest>() {}.getType();
		json = restCaller.doPost("http://localhost:8080/exams/",  gson.toJson(addExamRequest, type));
		System.out.println(json);
		
		return gson.fromJson(json, type);
		
	}
	
}
