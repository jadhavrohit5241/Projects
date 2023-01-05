package com.te.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.te.demo.dto.OtpVerificationDto;
import com.te.demo.dto.SmsDto;
import com.te.demo.entity.Employee;
import com.te.demo.entity.OtpEntity;
import com.te.demo.response.AppResponse;
import com.te.demo.service.AppServiceInterface;

@Controller
@RequestMapping("/appController")
public class AppController {
	@Autowired
	private AppServiceInterface appServiceInterface;

	@PostMapping("/register")
	private ResponseEntity<AppResponse> registerEmployee(@RequestBody Employee employee) {
		if (appServiceInterface.registerEmployee(employee)) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("registration Succesful")
					.timestamp(LocalDateTime.now()).build(), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(
				AppResponse.builder().error(true).message("registration failed").timestamp(LocalDateTime.now()).build(),
				HttpStatus.CONFLICT);
	}

	@PostMapping("/registerWithConfirmationLink")
	private ResponseEntity<AppResponse> registerWithConfirmationLink(@RequestBody Employee employee) {

		if (appServiceInterface.registerWithConfirmationLink(employee)) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("registration Succesful")
					.timestamp(LocalDateTime.now()).build(), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(
				AppResponse.builder().error(true).message("registration failed").timestamp(LocalDateTime.now()).build(),
				HttpStatus.CONFLICT);
	}

	@GetMapping("/confirm-account")
	private ResponseEntity<AppResponse> confirmUserAccount(@RequestParam(value = "token") String token) {
		if (appServiceInterface.validateToken(token)) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("Account validate ")
					.timestamp(LocalDateTime.now()).build(), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(
				AppResponse.builder().error(true).message("INVALID LINK").timestamp(LocalDateTime.now()).build(),
				HttpStatus.ACCEPTED);

	}

	@PostMapping("/smsOtp")
	private ResponseEntity<AppResponse> textOtp(@RequestBody SmsDto smsDto) {

		if (appServiceInterface.sendOtpBySms(smsDto)) {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).message("OTP send").timestamp(LocalDateTime.now()).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(
				AppResponse.builder().error(true).message("OTP NOT send").timestamp(LocalDateTime.now()).build(),
				HttpStatus.ACCEPTED);

	}

	@PostMapping("/otpByEmail")
	private ResponseEntity<AppResponse> otpByEmail(@RequestBody OtpVerificationDto otpVerificationDto) {

		if (appServiceInterface.sendOtpByEmail(otpVerificationDto)) {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).message("OTP send").timestamp(LocalDateTime.now()).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(
				AppResponse.builder().error(true).message("OTP NOT send").timestamp(LocalDateTime.now()).build(),
				HttpStatus.ACCEPTED);

	}

	@PostMapping("/validateOtpByEmail")
	private ResponseEntity<AppResponse> validateOtp(@RequestBody OtpEntity validateOtp) {

		if (appServiceInterface.validateOtp(validateOtp)) {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).message("OTP send").timestamp(LocalDateTime.now()).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(
				AppResponse.builder().error(true).message("OTP NOT send").timestamp(LocalDateTime.now()).build(),
				HttpStatus.ACCEPTED);

	}

}