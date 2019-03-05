package com.joelkingsley.rmkcet.spas.fe.beans;

import java.io.Serializable;

import com.joelkingsley.rmkcet.spas.fe.beans.UserType;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int userID;
	String name;
	String email;
	String password;
	UserType userType;
	Department department;
	
	public User(int userID, String name, String email, String password, UserType userType, Department department) {
		super();
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.department = department;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", userType=" + userType + ", department=" + department + "]";
	}
	
}
