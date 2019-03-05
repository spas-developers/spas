package com.joelkingsley.rmkcet.spas.fe.beans;

import java.io.Serializable;

public class UserType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int userTypeID;
	String name;
	
	public UserType(int userTypeID, String name) {
		super();
		this.userTypeID = userTypeID;
		this.name = name;
	}

	public int getUserTypeID() {
		return userTypeID;
	}

	public void setUserTypeID(int userTypeID) {
		this.userTypeID = userTypeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserType [userTypeID=" + userTypeID + ", name=" + name + "]";
	}
	
	
}
