package com.joelkingsley.rmkcet.spas.fe.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joelkingsley.rmkcet.spas.fe.beans.Batch;
import com.joelkingsley.rmkcet.spas.fe.beans.Department;
import com.joelkingsley.rmkcet.spas.fe.beans.Semester;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddSemesterRequest;
import com.joelkingsley.rmkcet.spas.fe.services.BatchesService;
import com.joelkingsley.rmkcet.spas.fe.services.DepartmentsService;
import com.joelkingsley.rmkcet.spas.fe.services.SemestersService;

/**
 * Servlet implementation class ManageSemesterServlet
 */
@WebServlet("/manageSemester")
public class ManageSemesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageSemesterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SemestersService semestersService = new SemestersService();
		ArrayList<Semester> semesters = semestersService.getAllSemesters();
		request.setAttribute("semesters", semesters);
		
		DepartmentsService departmentsService = new DepartmentsService();
		ArrayList<Department> departments = departmentsService.getAllDepartments();
		request.setAttribute("departments", departments);
		
		BatchesService batchesService = new BatchesService();
		ArrayList<Batch> batches = batchesService.getAllBatches();
		request.setAttribute("batches", batches);
		
		request.getRequestDispatcher("/administrator/pages/manage-semester.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("manageSemesterServlet doPost");
		
		SemestersService semestersService = new SemestersService();
		int semesterNumber = Integer.parseInt(request.getParameter("semesterNumber"));
		String batch = request.getParameter("batch");
		String department= request.getParameter("department");
		
		int batchID = Integer.parseInt(batch.split(":")[0]);
		int departmentID = Integer.parseInt(department.split(":")[0]);
		
		boolean submitButtonPressed = request.getParameter("addSemesterButton") != null;
		
		if (submitButtonPressed) {
			AddSemesterRequest addedSemester = semestersService.addSemester(new AddSemesterRequest(semesterNumber, batchID, departmentID));
			System.out.println(addedSemester);
		}
		
		doGet(request, response);
	}

}
