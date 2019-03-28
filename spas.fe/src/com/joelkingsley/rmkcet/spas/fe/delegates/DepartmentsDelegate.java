package com.joelkingsley.rmkcet.spas.fe.delegates;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joelkingsley.rmkcet.spas.fe.beans.Department;
import com.joelkingsley.rmkcet.spas.fe.utils.RestCaller;

public class DepartmentsDelegate {

	public ArrayList<Department> getAllDepartments() {
		ArrayList<Department> departments = null;
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		try {
			json = restCaller.doGet("http://localhost:8080/departments/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Department>>() {}.getType();
		System.out.println(json);
		departments = gson.fromJson(json, type);
		
		return departments;
	}
	
}
