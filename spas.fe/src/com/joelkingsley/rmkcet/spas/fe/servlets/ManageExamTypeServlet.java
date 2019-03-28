package com.joelkingsley.rmkcet.spas.fe.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joelkingsley.rmkcet.spas.fe.beans.Batch;
import com.joelkingsley.rmkcet.spas.fe.beans.ExamType;
import com.joelkingsley.rmkcet.spas.fe.services.BatchesService;
import com.joelkingsley.rmkcet.spas.fe.services.ExamTypesService;

/**
 * Servlet implementation class ManageExamTypeServlet
 */
@WebServlet("/manageExamType")
public class ManageExamTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageExamTypeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ExamTypesService examTypesService = new ExamTypesService();
		ArrayList<ExamType> examTypes = examTypesService.getAllExamTypes();
		request.setAttribute("examTypes", examTypes);
		request.getRequestDispatcher("/administrator/pages/manage-exam-type.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("manageExamTypeServlet doPost");
		
		ExamTypesService examTypesService = new ExamTypesService();
		String examTypeName = request.getParameter("examTypeName");
		String abbreviation = request.getParameter("abbreviation");
		
		boolean submitButtonPressed = request.getParameter("addExamTypeButton") != null;
		
		if (submitButtonPressed) {
			ExamType addedExamType = examTypesService.addExamType(new ExamType(examTypeName, abbreviation));
			System.out.println(addedExamType);
		}
		
		doGet(request, response);
	}

}
