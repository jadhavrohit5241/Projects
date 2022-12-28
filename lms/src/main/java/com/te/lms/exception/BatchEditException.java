package com.te.lms.exception;

import org.springframework.stereotype.Component;

@Component
public class BatchEditException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BatchEditException() {
		super("Batch Update Failed");
	}

	public BatchEditException(String message, Throwable cause) {
		super(message, cause);
	}

	public BatchEditException(String message) {
		super(message);
	}

	public BatchEditException(Throwable cause) {
		super(cause);
	}

}
