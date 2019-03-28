package com.joelkingsley.rmkcet.spas.fe.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joelkingsley.rmkcet.spas.fe.beans.Batch;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddExamRequest;
import com.joelkingsley.rmkcet.spas.fe.services.BatchesService;

/**
 * Servlet implementation class ManageBatchServlet
 */
@WebServlet("/manageBatch")
public class ManageBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageBatchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BatchesService batchesService = new BatchesService();
		ArrayList<Batch> batches = batchesService.getAllBatches();
		request.setAttribute("batches", batches);
		request.getRequestDispatcher("/administrator/pages/manage-batch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("manageBatchServlet doPost");
		
		BatchesService batchesService = new BatchesService();
		int batchStartYear = Integer.parseInt(request.getParameter("batchStartYear"));
		
		boolean submitButtonPressed = request.getParameter("addBatchButton") != null;
		
		if (submitButtonPressed) {
			Batch addedbatch = batchesService.addBatch(new Batch(batchStartYear));
			System.out.println(addedbatch);
		}
		
		doGet(request, response);
	}

}
