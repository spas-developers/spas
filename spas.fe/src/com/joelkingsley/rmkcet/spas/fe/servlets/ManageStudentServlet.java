package com.joelkingsley.rmkcet.spas.fe.servlets;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joelkingsley.rmkcet.spas.fe.beans.Batch;
import com.joelkingsley.rmkcet.spas.fe.beans.Department;
import com.joelkingsley.rmkcet.spas.fe.beans.Student;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddSemesterRequest;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddStudentRequest;
import com.joelkingsley.rmkcet.spas.fe.services.BatchesService;
import com.joelkingsley.rmkcet.spas.fe.services.DepartmentsService;
import com.joelkingsley.rmkcet.spas.fe.services.SemestersService;
import com.joelkingsley.rmkcet.spas.fe.services.StudentsService;

/**
 * Servlet implementation class ManageStudentServlet
 */
@WebServlet("/manageStudent")
public class ManageStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageStudentServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentsService studentsService = new StudentsService();
		ArrayList<Student> students = studentsService.getAllStudents();
		request.setAttribute("students", students);
		
		BatchesService batchesService = new BatchesService();
		ArrayList<Batch> batches = batchesService.getAllBatches();
		request.setAttribute("batches", batches);
		
		DepartmentsService departmentsService = new DepartmentsService();
		ArrayList<Department> departments = departmentsService.getAllDepartments();
		request.setAttribute("departments", departments);
		
		request.getRequestDispatcher("/administrator/pages/manage-student.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
System.out.println("manageStudentServlet doPost");
		
		StudentsService studentsService = new StudentsService();
		BigInteger registerNumber = BigInteger.valueOf(Long.parseLong((request.getParameter("registerNumber"))));
		String studentName = request.getParameter("studentName");
		String gender= request.getParameter("gender");
		
		if(gender == "Male") {
			gender = "M";
		} else {
			gender = "F";
		}
		boolean isHosteler = request.getParameter("isHosteler") != null;
		String batch = request.getParameter("batch");
		String department = request.getParameter("department");
		
		int batchID = Integer.parseInt(batch.split(":")[0]);
		int departmentID = Integer.parseInt(department.split(":")[0]);
		
		boolean submitButtonPressed = request.getParameter("addStudentButton") != null;
		
		if (submitButtonPressed) {
			AddStudentRequest addedStudent = studentsService.addStudent(new AddStudentRequest(registerNumber, studentName, gender, isHosteler, batchID, departmentID));
			System.out.println(addedStudent);
		}
		
		doGet(request, response);
	}

}
