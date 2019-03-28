package com.joelkingsley.rmkcet.spas.fe.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joelkingsley.rmkcet.spas.fe.beans.Subject;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddSemesterRequest;
import com.joelkingsley.rmkcet.spas.fe.services.SemestersService;
import com.joelkingsley.rmkcet.spas.fe.services.SubjectsService;

/**
 * Servlet implementation class ManageSubjectServlet
 */
@WebServlet("/manageSubject")
public class ManageSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageSubjectServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SubjectsService subjectsService = new SubjectsService();
		ArrayList<Subject> subjects = subjectsService.getAllSubjects();
		request.setAttribute("subjects", subjects);
		request.getRequestDispatcher("/administrator/pages/manage-subject.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("manageSubjectServlet doPost");
		
		SubjectsService subjectsService = new SubjectsService();
		String subjectCode = request.getParameter("subjectCode");
		String subjectName = request.getParameter("subjectName");
		int credits= Integer.parseInt(request.getParameter("credits"));
		
		boolean submitButtonPressed = request.getParameter("addSubjectButton") != null;
		
		if (submitButtonPressed) {
			Subject addedSubject = subjectsService.addSubject(new Subject(subjectCode, subjectName, credits));
			System.out.println(addedSubject);
		}
		
		doGet(request, response);
	}

}
