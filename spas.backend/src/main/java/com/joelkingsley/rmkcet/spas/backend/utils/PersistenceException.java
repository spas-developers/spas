package com.joelkingsley.rmkcet.spas.backend.utils;

public class PersistenceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String errorMessage;
	Exception exception;
	
	public PersistenceException(String errorMessage, Exception exception) {
		super();
		this.errorMessage = errorMessage;
		this.exception = exception;
	}
	
	public PersistenceException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

}
