package com.joelkingsley.rmkcet.spas.fe.delegates;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joelkingsley.rmkcet.spas.fe.beans.Semester;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddSemesterRequest;
import com.joelkingsley.rmkcet.spas.fe.utils.RestCaller;

public class SemestersDelegate {

	public ArrayList<Semester> getAllSemesters() {
		ArrayList<Semester> semesters = null;
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		try {
			json = restCaller.doGet("http://localhost:8080/semesters/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Semester>>() {}.getType();
		System.out.println(json);
		semesters = gson.fromJson(json, type);
		
		return semesters;
	}

	public AddSemesterRequest addSemester(AddSemesterRequest addSemesterRequest) {
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		Gson gson = new Gson();
		Type type = new TypeToken<AddSemesterRequest>() {}.getType();
		json = restCaller.doPost("http://localhost:8080/semesters/",  gson.toJson(addSemesterRequest, type));
		System.out.println(json);
		
		return gson.fromJson(json, type);
	}
	
}
