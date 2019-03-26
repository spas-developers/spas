package com.joelkingsley.rmkcet.spas.be.beans.requests;

public class AddUserRequest {

	int userID;
	String name;
	String email;
	String password;
	int departmentID;
	int userTypeID;
	
	public AddUserRequest() {
		super();
	}

	public AddUserRequest(int userID, String name, String email, String password, int departmentID, int userTypeID) {
		super();
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.departmentID = departmentID;
		this.userTypeID = userTypeID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public int getUserTypeID() {
		return userTypeID;
	}

	public void setUserTypeID(int userTypeID) {
		this.userTypeID = userTypeID;
	}
	
	
}
