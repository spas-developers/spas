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
import com.joelkingsley.rmkcet.spas.fe.services.BatchesService;
import com.joelkingsley.rmkcet.spas.fe.services.DepartmentsService;

/**
 * Servlet implementation class ManageDepartmentServlet
 */
@WebServlet("/manageDepartment")
public class ManageDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageDepartmentServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentsService departmentsService = new DepartmentsService();
		ArrayList<Department> departments = departmentsService.getAllDepartments();
		request.setAttribute("departments", departments);
		request.getRequestDispatcher("/administrator/pages/manage-department.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("manageDepartmentServlet doPost");
		
		DepartmentsService departmentsService = new DepartmentsService();
		String departmentName = request.getParameter("department");
		String abbreviation = request.getParameter("abbreviation");
		
		System.out.println(departmentName);
		System.out.println(abbreviation);
		
		boolean submitButtonPressed = request.getParameter("addDepartmentButton") != null;
		
		if (submitButtonPressed) {
			Department addedDepartment = departmentsService.addDepartment(new Department(departmentName, abbreviation));
			System.out.println(addedDepartment);
		}
		
		doGet(request, response);
	}

}
