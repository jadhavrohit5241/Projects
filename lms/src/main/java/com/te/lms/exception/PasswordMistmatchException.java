package com.te.lms.exception;

public class PasswordMistmatchException extends RuntimeException{

	private static final long serialVersionUID = -4571195025248111045L;

	public PasswordMistmatchException() {

	}

	public PasswordMistmatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PasswordMistmatchException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public PasswordMistmatchException(String message) {
		super(message);

	}

	public PasswordMistmatchException(Throwable cause) {
		super(cause);
	}

}
