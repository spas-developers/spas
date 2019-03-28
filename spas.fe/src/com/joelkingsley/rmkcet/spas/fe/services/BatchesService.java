package com.joelkingsley.rmkcet.spas.fe.services;

import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.fe.beans.Batch;
import com.joelkingsley.rmkcet.spas.fe.beans.requests.AddExamResultRequest;
import com.joelkingsley.rmkcet.spas.fe.delegates.BatchesDelegate;

public class BatchesService {

BatchesDelegate batchesDelegate;
	
	public BatchesService() {
		super();
		batchesDelegate = new BatchesDelegate();
	}
	
	public ArrayList<Batch> getAllBatches() {
		return batchesDelegate.getAllBatches();
	}
	
	public Batch addBatch(Batch batch) {
		return batchesDelegate.addBatch(batch);
	}
	
}
