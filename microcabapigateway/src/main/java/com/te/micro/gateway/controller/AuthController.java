package com.te.micro.gateway.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.micro.gateway.response.ErrorResponse;

@RestController

/* 
 * FOR HYSTRIX LIB CREATED FALLBACK METHODS 
 *
 */

public class FallbackCotroller {

	@GetMapping("/userServiceFallbackMethod")
	private ResponseEntity<ErrorResponse> userServiceFallbackMethod() {
		return new ResponseEntity<>(ErrorResponse.builder().error(true).timestamp(LocalDate.now().toString())
				.errorMessage("UserService is Down try again later").build(), HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@GetMapping("/driverServiceFallbackMethod")
	private ResponseEntity<ErrorResponse> driverServiceFallbackMethod() {
		return new ResponseEntity<>(ErrorResponse.builder().error(true).timestamp(LocalDate.now().toString())
				.errorMessage("driver service is Down try again later").build(), HttpStatus.SERVICE_UNAVAILABLE);
	}
}
