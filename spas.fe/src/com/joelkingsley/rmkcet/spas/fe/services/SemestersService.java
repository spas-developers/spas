package com.joelkingsley.rmkcet.spas.fe.services;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.fe.beans.Semester;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddSemesterRequest;
import com.joelkingsley.rmkcet.spas.fe.delegates.SemestersDelegate;

public class SemestersService {

SemestersDelegate semestersDelegate;
	
	public SemestersService() {
		super();
		semestersDelegate = new SemestersDelegate();
	}
	
	public ArrayList<Semester> getAllSemesters() {
		return semestersDelegate.getAllSemesters();
	}
	
	public AddSemesterRequest addSemester(AddSemesterRequest addSemesterRequest) {
		return semestersDelegate.addSemester(addSemesterRequest);
	}
	
}
