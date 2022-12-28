package com.te.lms.exception;

public class NullInputException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String exceptionMsg;

	public NullInputException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NullInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NullInputException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NullInputException(String message) {
		
		NullInputException.exceptionMsg=message;
		}

	public NullInputException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
