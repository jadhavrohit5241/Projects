package com.te.micro.userservice.controller;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.micro.userservice.custexception.DataNotFoundException;
import com.te.micro.userservice.response.AppResponse;

@RestControllerAdvice
public class GlobalExeptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<AppResponse> exceptionHandler(MethodArgumentNotValidException argumentNotValidException) {
		HashMap<String, String> hashMap = new HashMap<>();
		argumentNotValidException.getBindingResult().getFieldErrors()
				.forEach((error) -> hashMap.put(error.getField(), error.getDefaultMessage()));
		return new ResponseEntity<>(AppResponse.builder().error(true).data(Arrays.asList(hashMap)).status(400).build(),
				HttpStatus.BAD_REQUEST);
	}	

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<AppResponse> exceptionHandler(DataNotFoundException dataNotFoundException) {
		return new ResponseEntity<>(AppResponse.builder().error(true)
				.data(Arrays.asList(dataNotFoundException.getMessage())).status(204).build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<AppResponse> exceptionHandler(RuntimeException runtimeException) {
		return new ResponseEntity<>(AppResponse.builder().error(true).data(Arrays.asList(runtimeException.getMessage()))
				.status(400).build(), HttpStatus.BAD_REQUEST);
	}
}
