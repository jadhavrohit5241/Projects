package com.te.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.demo.dto.OtpVerificationDto;
import com.te.demo.dto.SmsDto;
import com.te.demo.emailsender.EmailSenderService;
import com.te.demo.entity.ConfirmationToken;
import com.te.demo.entity.Employee;
import com.te.demo.entity.OtpEntity;
import com.te.demo.repository.ConfirmationTokenRepository;
import com.te.demo.repository.EmployeeRepository;
import com.te.demo.repository.OtpRepository;
import com.te.demo.smssender.SmsSender;

@Service
public class AppServiceImpl implements AppServiceInterface {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmailSenderService emailSenderService;

	@Autowired
	private OtpRepository otpRepository;

	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	private SmsSender smsSender;

	@Override
	public boolean registerEmployee(Employee employee) {

		employeeRepository.save(employee);
		emailSenderService.sendEmail(employee.getEmail(), "TE Registration",
				"MR" + employee.getEmployeeName() + "/n YOUE REGISTRATION SUCCESSFULLY DONE");
		return true;
	}

	@Override
	public boolean registerWithConfirmationLink(Employee employee) {
		Optional<Employee> optional = employeeRepository.findByUserName(employee.getUserName());
		if (optional.isPresent()) {
			return false;
		} else {
			employeeRepository.save(employee);
			ConfirmationToken confirmationToken = new ConfirmationToken(employee);
			confirmationTokenRepository.save(confirmationToken);
			emailSenderService.sendEmail(employee.getEmail(), "validationLink", "To confirm your account press here "+" "
					+ "http://localhost:8080/confirm-account?" +confirmationToken.getConfirmationToken());
			return true;
		}

	}

	@Override
	public boolean sendOtpBySms(SmsDto smsDto) {
		if (validateNumber(smsDto.getMobNo(), "+91")) {
			smsSender.send(smsDto);
			return true;
		}
		return false;
	}

	private static boolean validateNumber(String phoneNumbers, String country) {
		// google phone number validator
		return true;
	}

	@Override
	public boolean sendOtpByEmail(OtpVerificationDto otpVerificationDto) {
		Optional<OtpEntity> optional = otpRepository.findById(otpVerificationDto.getUsername());
		if (optional.isPresent()) {
			Optional<Employee> empOptional = employeeRepository.findByUserName(otpVerificationDto.getUsername());
			String tempOtp = genrateOtp().toString();
			optional.get().setOtp(tempOtp);
			Employee employee = empOptional.get();
			emailSenderService.sendEmail(employee.getEmail(), "OTP",
					"YOUR OTP IS" + tempOtp + "IT WILL VALID FOR NEXT 30 SEC");
			return true;
		} else {
			Optional<Employee> empOptional = employeeRepository.findByUserName(otpVerificationDto.getUsername());
			String tempOtp = genrateOtp().toString();
			otpRepository.save(OtpEntity.builder().userName(otpVerificationDto.getUsername()).otp(tempOtp).build());
			Employee employee = empOptional.get();
			emailSenderService.sendEmail(employee.getEmail(), "OTP",
					"YOUR OTP IS" + tempOtp + "IT WILL VALID FOR NEXT 30 SEC");

			return true;
		}

	}

	@Override
	public boolean validateToken(String token) {
		Optional<ConfirmationToken> confirmationTokenOptional = confirmationTokenRepository
				.findByConfirmationToken(token);
		if (confirmationTokenOptional.isPresent()) {
			ConfirmationToken confirmationToken = confirmationTokenOptional.get();
			confirmationToken.getEmployee().setAccountStatus(true);
			confirmationTokenRepository.save(confirmationToken);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean validateOtp(OtpEntity validateOtp) {
		OtpEntity otpEntity = otpRepository.findById(validateOtp.getUserName())
				.orElseThrow(() -> new RuntimeException("Invalid username"));
		if (otpEntity.getOtp().equals(validateOtp.getOtp())) {
			return true;
		}
		return false;
	}

	public static Integer genrateOtp() {
		return (int) (Math.random() * 10000);
	}
}
