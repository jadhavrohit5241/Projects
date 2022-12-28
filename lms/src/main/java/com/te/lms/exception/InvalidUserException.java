package com.te.lms.exception;

public class InvalidUserException extends RuntimeException {

	private static final long serialVersionUID = 1367489156867370981L;

	public InvalidUserException(String message) {
		super(message);
	}

}
