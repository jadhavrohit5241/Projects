package com.te.pcmjwt.controller;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.pcmjwt.appresponse.AppResponse;
import com.te.pcmjwt.exceptions.DataNotFoundException;
import com.te.pcmjwt.exceptions.InvalidUserInput;
import com.te.pcmjwt.exceptions.UserNotFoundException;

@RestControllerAdvice
public class GlobalExeptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<AppResponse> exceptionHandler(UserNotFoundException userNotFoundException) {

		return new ResponseEntity<>(AppResponse.builder().error(true)
				.data(Arrays.asList(userNotFoundException.getMessage())).status(204).build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<AppResponse> exceptionHandler(DataNotFoundException dataNotFoundException) {

		return new ResponseEntity<>(AppResponse.builder().error(true)
				.data(Arrays.asList(dataNotFoundException.getMessage())).status(204).build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidUserInput.class)
	public ResponseEntity<AppResponse> exceptionHandler(InvalidUserInput invalidUserInput) {

		return new ResponseEntity<>(AppResponse.builder().error(true).data(Arrays.asList(invalidUserInput.getMessage()))
				.status(204).build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<AppResponse> exceptionHandler(RuntimeException runtimeException) {

		return new ResponseEntity<>(AppResponse.builder().error(true).data(Arrays.asList(runtimeException.getMessage()))
				.status(204).build(), HttpStatus.BAD_REQUEST);
	}
}
