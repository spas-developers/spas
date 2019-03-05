package com.joelkingsley.rmkcet.spas.fe.delegates;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joelkingsley.rmkcet.spas.fe.beans.ExamResult;
import com.joelkingsley.rmkcet.spas.fe.utils.RestCaller;

public class ExamResultsDelegate {

	public ArrayList<ExamResult> getAllExamResultsOfRegisterNumber(BigInteger registerNumber) {
		ArrayList<ExamResult> examResults = null;
		RestCaller restCaller = new RestCaller();
		
		String json = null;
		try {
			json = restCaller.doGet("http://localhost:8080/examResults/" + registerNumber);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<ExamResult>>() {}.getType();
		System.out.println(json);
		examResults = gson.fromJson(json, type);
		
		return examResults;
	}

}
