package com.te.securityjwt.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.security.exceptions.InvalidUserInput;
import com.te.securityjwt.dto.AssignRoleDto;
import com.te.securityjwt.dto.EmployeeRegisterDto;
import com.te.securityjwt.dto.GetAllEmployeeDto;
import com.te.securityjwt.dto.LoginDto;
import com.te.securityjwt.entity.Employee;
import com.te.securityjwt.jwtutil.JwtUtil;
import com.te.securityjwt.response.AppResponse;
import com.te.securityjwt.service.ServiceInterface;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AppController {
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private ServiceInterface serviceInterface;

	@PostMapping("/register")
	public ResponseEntity<AppResponse> register(@Valid @RequestBody EmployeeRegisterDto employeeRegisterDto) {
		serviceInterface.register(employeeRegisterDto);
		return new ResponseEntity<>(AppResponse.builder().timestamp(LocalDate.now().toString()).error(false)
				.msg("REGISTER SUCCESS").data(Arrays.asList(employeeRegisterDto)).status(204).build(),
				HttpStatus.ACCEPTED);
	}

	

	@PostMapping("/login")
	private ResponseEntity<AppResponse> generateToken(@RequestBody LoginDto loginDto) {
		String token;
		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
			token = jwtUtil.generateToken(loginDto.getUsername());
			// serviceInterface.saveTokenInDatabase(loginDto.getUsername(), token);

		} catch (Exception exception) {
			System.out.println("catch block");
			throw new InvalidUserInput("Invalid CREDENTIALS");

		}

		return new ResponseEntity<>(
				AppResponse.builder().status(200).data(Arrays.asList(token)).msg("token created").timestamp(LocalDate.now().toString()).error(false).build(),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAllEmployee")
	private ResponseEntity<AppResponse> getAllEmployee() {
		Optional<List<GetAllEmployeeDto>> optional = serviceInterface.getAllEmployee();
		return new ResponseEntity<>(
				AppResponse.builder().status(200).data(Arrays.asList(optional)).error(false).msg("DATA FOUND").build(),
				HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getDetails")
	private ResponseEntity<AppResponse> getDetails(@RequestParam String username) {
		Optional<Employee> optional = serviceInterface.getDetails(username);
		return new ResponseEntity<>(
				AppResponse.builder().status(200).data(Arrays.asList(optional)).error(false).msg("DATA FOUND").build(),
				HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/assignRole")
	private ResponseEntity<AppResponse> assignRole(@RequestBody AssignRoleDto assignRoleDto) {
		Boolean bool= serviceInterface.assignRole(assignRoleDto);
		return new ResponseEntity<>(
				AppResponse.builder().status(200).timestamp(LocalDate.now().toString()).data(Arrays.asList()).error(bool).msg("ROLE UPDATED SUCCESSFULLY").build(),
				HttpStatus.ACCEPTED);
	}
	
	@ExceptionHandler(InvalidUserInput.class)
	public ResponseEntity<AppResponse> exceptionHandler(InvalidUserInput invalidUserInput) {

		return new ResponseEntity<>(
				AppResponse.builder().timestamp(LocalDate.now().toString()).error(true)
						.data(Arrays.asList(invalidUserInput.getMessage())).status(204).build(),
				HttpStatus.BAD_REQUEST);
	}
}
