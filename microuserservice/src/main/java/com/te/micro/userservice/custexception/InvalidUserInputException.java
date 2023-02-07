package com.te.micro.userservice.custexception;

public class InvalidUserInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3294075666599541182L;

	public InvalidUserInputException() {
		super();
	}

	public InvalidUserInputException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidUserInputException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidUserInputException(String message) {
		super(message);
	}

	public InvalidUserInputException(Throwable cause) {
		super(cause);
	}

}
