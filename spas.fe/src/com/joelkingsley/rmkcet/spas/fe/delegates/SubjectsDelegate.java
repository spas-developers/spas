package com.joelkingsley.rmkcet.spas.fe.delegates;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joelkingsley.rmkcet.spas.fe.beans.Subject;
import com.joelkingsley.rmkcet.spas.fe.utils.RestCaller;

public class SubjectsDelegate {

	public ArrayList<Subject> getAllSubjects() {
		ArrayList<Subject> subjects = null;
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		try {
			json = restCaller.doGet("http://localhost:8080/subjects/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Subject>>() {}.getType();
		System.out.println(json);
		subjects = gson.fromJson(json, type);
		
		return subjects;
	}

	public Subject addSubject(Subject subject) {
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		Gson gson = new Gson();
		Type type = new TypeToken<Subject>() {}.getType();
		json = restCaller.doPost("http://localhost:8080/subjects/",  gson.toJson(subject, type));
		System.out.println(json);
		
		return gson.fromJson(json, type);
		
	}
	
}
