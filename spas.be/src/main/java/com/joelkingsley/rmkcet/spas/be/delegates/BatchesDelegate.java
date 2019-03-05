package com.joelkingsley.rmkcet.spas.be.delegates;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Batch;
import com.joelkingsley.rmkcet.spas.be.daos.BatchesDAO;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;

public class BatchesDelegate {
BatchesDAO batchesDAO;
	
	public BatchesDelegate() {
		super();
		batchesDAO = new BatchesDAO();
	}

	public ArrayList<Batch> getAllBatches() throws AppError {
		try {
			return batchesDAO.getAllBatches();
		} catch (AppError e) {
			e.printStackTrace();
			throw e;
		}
	}
	

}
