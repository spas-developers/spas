package com.joelkingsley.rmkcet.spas.be.utils;

public class AppError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String errorMessage;
	Exception exception;
	
	public AppError(String errorMessage, Exception exception) {
		super();
		this.errorMessage = errorMessage;
		this.exception = exception;
	}
	
	public AppError(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	@Override
	public String toString() {
		return "AppError [errorMessage=" + errorMessage + ", exception=" + exception + "]";
	}
	
	

}
