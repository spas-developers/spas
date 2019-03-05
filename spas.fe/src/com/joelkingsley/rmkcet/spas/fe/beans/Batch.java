package com.joelkingsley.rmkcet.spas.fe.beans;

import java.io.Serializable;

public class Batch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int batchID ;
	int batchStartYear;
	public Batch(int batchID, int batchStartYear) {
		super();
		this.batchID = batchID;
		this.batchStartYear = batchStartYear;
	}
	public int getBatchID() {
		return batchID;
	}
	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}
	public int getBatchStartYear() {
		return batchStartYear;
	}
	public void setBatchStartYear(int batchStartYear) {
		this.batchStartYear = batchStartYear;
	}
	@Override
	public String toString() {
		return "Batch [batchID=" + batchID + ", batchStartYear=" + batchStartYear + "]";
	}

}
