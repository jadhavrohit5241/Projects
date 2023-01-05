package com.te.demo.service;

import com.te.demo.dto.OtpVerificationDto;
import com.te.demo.dto.SmsDto;
import com.te.demo.entity.Employee;
import com.te.demo.entity.OtpEntity;

public interface AppServiceInterface {

	boolean registerEmployee(Employee employee);

	boolean sendOtpBySms(SmsDto smsDto);

	boolean sendOtpByEmail(OtpVerificationDto otpVerificationDto); 

	boolean validateOtp(OtpEntity validateOtp);

	boolean registerWithConfirmationLink(Employee employee);

	boolean validateToken(String token);
}
