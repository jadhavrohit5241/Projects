package com.te.lms.exception;

import org.springframework.stereotype.Component;

@Component
public class BatchDeleteException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BatchDeleteException() {
		super("batch Not Registerrd");
	}

	public BatchDeleteException(String message, Throwable cause) {
		super(message, cause);
	}

	public BatchDeleteException(String message) {
		super(message);
	}

	public BatchDeleteException(Throwable cause) {
		super(cause);
	}
}
