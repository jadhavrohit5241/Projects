package com.te.lms.exception;

import org.springframework.stereotype.Component;

@Component
public class BatchNotRegister extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BatchNotRegister() {
		super("batch Not Registerrd");
	}

	public BatchNotRegister(String message, Throwable cause) {
		super(message, cause);
	}

	public BatchNotRegister(String message) {
		super(message);
	}

	public BatchNotRegister(Throwable cause) {
		super(cause);
	}
}
