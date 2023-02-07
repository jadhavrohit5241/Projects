package com.te.micro.userservice.controller;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.micro.userservice.dto.RestTemplateVo;
import com.te.micro.userservice.dto.UserDto;
import com.te.micro.userservice.response.AppResponse;
import com.te.micro.userservice.service.DriverController;
import com.te.micro.userservice.service.UserServiceInterface;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceInterface userServiceInterface;

	@Autowired
	private DriverController driverController;

	@PostMapping("/register")
	public ResponseEntity<AppResponse> upload(@RequestBody UserDto userDto) {
		return ResponseEntity.ok(AppResponse.builder().status(200).msg("Data saved in DataBase")
				.data(Arrays.asList(userServiceInterface.register(userDto))).timestamp(LocalDate.now().toString())
				.error(false).build());

	}

	@GetMapping("getUserInfo/{userId}")
	public ResponseEntity<AppResponse> getUserInfo(@PathVariable Integer userId) {
		return ResponseEntity
				.ok(AppResponse.builder().status(200).msg("Data found").data(userServiceInterface.getUserInfo(userId))
						.timestamp(LocalDate.now().toString()).error(false).build());

	}

	@GetMapping("getTripDetails/{userId}/{driverId}")
	//@CircuitBreaker(name = "driverService",fallbackMethod = "driverServiceFallbackMethod")
	//@Retry(name = "driverService",fallbackMethod = "driverServiceFallbackMethod")
	@RateLimiter(name = "driverService",fallbackMethod = "driverServiceFallbackMethod")
	
	public ResponseEntity<AppResponse> getTripDetails(@PathVariable Integer userId, @PathVariable Integer driverId) {
		return ResponseEntity.ok(AppResponse.builder().status(200).msg("Data found")
				.data(Arrays.asList(RestTemplateVo.builder().driver(driverController.getDriverInfo(driverId).getBody().getData())
						.user(userServiceInterface.getUserInfo(userId)).build()))
				.timestamp(LocalDate.now().toString()).error(false).build());
	}
	
	
	@GetMapping("/driverServiceFallbackMethod")
	private ResponseEntity<AppResponse> driverServiceFallbackMethod(Exception exception) {
		System.err.println("driverServiceFallbackMethod");
		return new ResponseEntity<>(AppResponse.builder().error(true).timestamp(LocalDate.now().toString())
				.msg("driver service is Down try again later").build(), HttpStatus.SERVICE_UNAVAILABLE);
	}
}

/*
 * 
 * @Autowired private RestTemplate restTemplate;
 * 
 * @GetMapping("getTripDetails/{userId}/{driverId}") public
 * ResponseEntity<AppResponse> getTripDetails(@PathVariable Integer
 * userId, @PathVariable Integer driverId) { Object forObject =
 * restTemplate.getForObject("http://DRIVER-SERVICE/driver/getDriverInfo/"+
 * driverId, Object.class); System.err.println(forObject); UserDto userInfo =
 * userServiceInterface.getUserInfo(userId); return
 * ResponseEntity.ok(AppResponse.builder().status(200).msg("Data found")
 * .data(Arrays.asList(RestTemplateVo.builder().driver(forObject).user(userInfo)
 * .build())) .timestamp(LocalDate.now().toString()).error(false).build()); }
 */