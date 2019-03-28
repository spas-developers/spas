package com.joelkingsley.rmkcet.spas.fe.delegates;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joelkingsley.rmkcet.spas.fe.beans.User;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddUserRequest;
import com.joelkingsley.rmkcet.spas.fe.utils.RestCaller;

public class UsersDelegate {

	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = null;
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		try {
			json = restCaller.doGet("http://localhost:8080/users/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<User>>() {}.getType();
		System.out.println(json);
		users = gson.fromJson(json, type);
		
		return users;
	}

	public AddUserRequest addUser(AddUserRequest addUserRequest) {
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		Gson gson = new Gson();
		Type type = new TypeToken<AddUserRequest>() {}.getType();
		json = restCaller.doPost("http://localhost:8080/users/",  gson.toJson(addUserRequest, type));
		System.out.println(json);
		
		return gson.fromJson(json, type);
	}
	
}
