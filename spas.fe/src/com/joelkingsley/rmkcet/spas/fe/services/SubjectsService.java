package com.joelkingsley.rmkcet.spas.fe.services;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.fe.beans.Subject;
import com.joelkingsley.rmkcet.spas.fe.delegates.SubjectsDelegate;

public class SubjectsService {

	SubjectsDelegate subjectsDelegate;
	
	public SubjectsService() {
		super();
		subjectsDelegate = new SubjectsDelegate();
	}
	
	public ArrayList<Subject> getAllSubjects() {
		return subjectsDelegate.getAllSubjects();
	}
	
	public Subject addSubject(Subject subject) {
		return subjectsDelegate.addSubject(subject);
	}
	
}
