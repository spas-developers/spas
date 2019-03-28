package com.joelkingsley.rmkcet.spas.fe.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joelkingsley.rmkcet.spas.fe.beans.Exam;
import com.joelkingsley.rmkcet.spas.fe.beans.ExamType;
import com.joelkingsley.rmkcet.spas.fe.beans.Semester;
import com.joelkingsley.rmkcet.spas.fe.beans.Subject;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddExamRequest;
import com.joelkingsley.rmkcet.spas.fe.services.ExamTypesService;
import com.joelkingsley.rmkcet.spas.fe.services.ExamsService;
import com.joelkingsley.rmkcet.spas.fe.services.SemestersService;
import com.joelkingsley.rmkcet.spas.fe.services.SubjectsService;

/**
 * Servlet implementation class ManageExamServlet
 */
@WebServlet("/manageExam")
public class ManageExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageExamServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ExamTypesService examTypesService = new ExamTypesService();
		ArrayList<ExamType> examTypes = examTypesService.getAllExamTypes();
		request.setAttribute("examTypes", examTypes);
		
		SubjectsService subjectsService = new SubjectsService();
		ArrayList<Subject> subjects = subjectsService.getAllSubjects();
		request.setAttribute("subjects", subjects);
		
		SemestersService semestersService = new SemestersService();
		ArrayList<Semester> semesters = semestersService.getAllSemesters();
		request.setAttribute("semesters", semesters);
		
		ExamsService examsService = new ExamsService();
		ArrayList<Exam> exams = examsService.getAllExams();
		request.setAttribute("exams", exams);
		
		request.getRequestDispatcher("/administrator/pages/manage-exam.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("manageExamServlet doPost");
		
		ExamsService examsService = new ExamsService();
		String examType = request.getParameter("examType");
		String subject = request.getParameter("subject");
		String semester = request.getParameter("semester");
		
		int examTypeID = Integer.parseInt(examType.split(":")[0]);
		int subjectID = Integer.parseInt(subject.split(":")[0]);
		int semesterID = Integer.parseInt(semester.split(":")[0]);
		
		boolean submitButtonPressed = request.getParameter("addExamButton") != null;
		
		if (submitButtonPressed) {
			AddExamRequest addedExam = examsService.addExam(new AddExamRequest(
					examTypeID,
					subjectID,
					semesterID
					));
			System.out.println(addedExam);
		}
		
		doGet(request, response);
	}

}
