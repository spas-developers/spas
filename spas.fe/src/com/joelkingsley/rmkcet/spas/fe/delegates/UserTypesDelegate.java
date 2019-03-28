package com.joelkingsley.rmkcet.spas.fe.delegates;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joelkingsley.rmkcet.spas.fe.beans.UserType;
import com.joelkingsley.rmkcet.spas.fe.utils.RestCaller;

public class UserTypesDelegate {

	public ArrayList<UserType> getAllUserTypes() {
		ArrayList<UserType> userTypes = null;
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		try {
			json = restCaller.doGet("http://localhost:8080/batches/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<UserType>>() {}.getType();
		System.out.println(json);
		userTypes = gson.fromJson(json, type);
		
		return userTypes;
	}
	
	public UserType addUserType(UserType userType) {
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		Gson gson = new Gson();
		Type type = new TypeToken<UserType>() {}.getType();
		json = restCaller.doPost("http://localhost:8080/userTypes/",  gson.toJson(userType, type));
		System.out.println(json);
		
		return gson.fromJson(json, type);
		
	}
	
}
