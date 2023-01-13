package com.te.security.exceptions;

public class InvalidUserInput extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUserInput() {
		super();
	}

	public InvalidUserInput(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidUserInput(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidUserInput(String message) {
		super(message);
	}

	public InvalidUserInput(Throwable cause) {
		super(cause);
	}

}
