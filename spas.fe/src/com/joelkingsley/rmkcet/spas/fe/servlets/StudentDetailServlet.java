package com.joelkingsley.rmkcet.spas.fe.servlets;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joelkingsley.rmkcet.spas.fe.beans.ExamResult;
import com.joelkingsley.rmkcet.spas.fe.beans.ExamType;
import com.joelkingsley.rmkcet.spas.fe.beans.Subject;
import com.joelkingsley.rmkcet.spas.fe.services.ExamResultsService;
import com.joelkingsley.rmkcet.spas.fe.services.ExamTypesService;
import com.joelkingsley.rmkcet.spas.fe.services.SubjectsService;

/**
 * Servlet implementation class StudentDetailServlet
 */
@WebServlet("/studentDetail")
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDetailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/general/pages/student-search.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BigInteger registerNumber = BigInteger.valueOf(Long.parseLong(request.getParameter("search-value")));
		ExamResultsService examResultsService = new ExamResultsService();
		ArrayList<ExamResult> examResults = examResultsService.getAllExamResultsOfRegisterNumber(registerNumber);
		request.setAttribute("examResults", examResults);
		
		ExamTypesService examTypesService = new ExamTypesService();
		ArrayList<ExamType> examTypes = examTypesService.getAllExamTypes();
		request.setAttribute("examTypes", examTypes);
		
		SubjectsService subjectsService = new SubjectsService();
		ArrayList<Subject> subjects = subjectsService.getAllSubjects();
		request.setAttribute("subjects", subjects);
		
		request.getRequestDispatcher("/general/pages/student-detail.jsp").forward(request, response);
		// doGet(request, response);
	}

}
