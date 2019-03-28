package com.joelkingsley.rmkcet.spas.fe.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joelkingsley.rmkcet.spas.fe.beans.Exam;
import com.joelkingsley.rmkcet.spas.fe.beans.ExamResult;
import com.joelkingsley.rmkcet.spas.fe.beans.Student;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddExamResultRequest;
import com.joelkingsley.rmkcet.spas.fe.services.ExamResultsService;
import com.joelkingsley.rmkcet.spas.fe.services.ExamsService;
import com.joelkingsley.rmkcet.spas.fe.services.StudentsService;

/**
 * Servlet implementation class ManageExamResultServlet
 */
@WebServlet("/manageExamResult")
public class ManageExamResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageExamResultServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ExamResultsService examResultsService = new ExamResultsService();
		ArrayList<ExamResult> examResults = examResultsService.getAllExamResults();
		request.setAttribute("examResults", examResults);
		
		ExamsService examsService = new ExamsService();
		ArrayList<Exam> exams = examsService.getAllExams();
		request.setAttribute("exams", exams);
		
		StudentsService studentsService = new StudentsService();
		ArrayList<Student> students = studentsService.getAllStudents();
		request.setAttribute("students", students);
		
		request.getRequestDispatcher("/administrator/pages/manage-exam-result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ExamResultsService examResultsService = new ExamResultsService();
		String exam = request.getParameter("exam");
		String student = request.getParameter("student");
		int marks = Integer.parseInt(request.getParameter("marks"));
		String grade = request.getParameter("grade");
		
		int examID = Integer.parseInt(exam.split(":")[0]);
		int studentID = Integer.parseInt(student.split(":")[0]);
		
		boolean submitButtonPressed = request.getParameter("addExamResultButton") != null;
		
		if (submitButtonPressed) {
			AddExamResultRequest addedExamResult = examResultsService.addExamResult(new AddExamResultRequest(examID, studentID, marks, grade));
			System.out.println(addedExamResult);
		}
		
		doGet(request, response);
	}

}
