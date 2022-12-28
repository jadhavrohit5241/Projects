package com.te.lms.exception;

import org.springframework.stereotype.Component;

@Component
public class UserFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserFoundException() {
		super("User with this username is already there in database!! Try with another username");
	}

	public UserFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
