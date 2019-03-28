package com.joelkingsley.rmkcet.spas.fe.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joelkingsley.rmkcet.spas.fe.beans.Exam;
import com.joelkingsley.rmkcet.spas.fe.beans.Student;
import com.joelkingsley.rmkcet.spas.fe.services.ExamsService;
import com.joelkingsley.rmkcet.spas.fe.services.StudentsService;

/**
 * Servlet implementation class ExamDashboard
 */
@WebServlet("/examDashboard")
public class ExamDashboardServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamDashboardServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ExamsService examsService = new ExamsService();
		ArrayList<Exam> exams = examsService.getAllExams();
		request.setAttribute("exams", exams);
		request.getRequestDispatcher("/general/pages/exam-dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
