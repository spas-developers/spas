package com.joelkingsley.rmkcet.spas.backend.beans;

public class User {

	int userID;
	String name;
	String email;
	String password;
	UserType userType;
	
	public User(int userID, String name, String email, String password, UserType userType) {
		super();
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userType = userType;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", userType=" + userType + "]";
	}
	
	
}
