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
import com.joelkingsley.rmkcet.spas.fe.services.ExamResultsService;

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
		request.getRequestDispatcher("/general/pages/student-detail.jsp").forward(request, response);
		// doGet(request, response);
	}

}
