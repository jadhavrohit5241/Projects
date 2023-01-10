package com.te.pcmjwt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.pcmjwt.appresponse.AppResponse;
import com.te.pcmjwt.dto.DeptAddDto;
import com.te.pcmjwt.dto.EmployeeRegisterDto;
import com.te.pcmjwt.dto.GetAllEmployeeDto;
import com.te.pcmjwt.dto.JwtDto;
import com.te.pcmjwt.dto.UpdateDeptDto;
import com.te.pcmjwt.exceptions.UserNotFoundException;
import com.te.pcmjwt.jwtutil.JwtUtil;
import com.te.pcmjwt.service.ServiceInterface;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth/employee")
public class AppController {
	@Autowired
	private AppResponse appResponse;

	@Autowired
	private ServiceInterface serviceInterface;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/token")
	private ResponseEntity<AppResponse> generateToken(@RequestBody JwtDto dto) {
		try {
			this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
		} catch (UsernameNotFoundException exception) {

			throw new UserNotFoundException("Invalid User ID");
		}
		String token = jwtUtil.generateToken(dto.getUsername());
		serviceInterface.saveTokenInDatabase(dto.getUsername(),token);
		return new ResponseEntity<>(
				AppResponse.builder().status(200).data(Arrays.asList(token)).msg("token created").error(false).build(),
				HttpStatus.ACCEPTED);
	}

	@PostMapping("/register")
	public ResponseEntity<AppResponse> register(@Valid@RequestBody EmployeeRegisterDto employeeRegisterDto) {
		if (serviceInterface.register(employeeRegisterDto)) {
			appResponse.setError(false);
			appResponse.setMsg("successful");
			appResponse.setStatus(200);
		}
		return new ResponseEntity<>(appResponse, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAllEmployee")
	private ResponseEntity<AppResponse> getAllEmployee() {
		Optional<List<GetAllEmployeeDto>> optional = serviceInterface.getAllEmployee();
		if (optional.isPresent()) {
			return new ResponseEntity<>(AppResponse.builder().status(200).data(Arrays.asList(optional)).error(false)
					.msg("DATA FOUND").build(), HttpStatus.ACCEPTED);
		} else {
			throw new RuntimeException("data not found");
		}

	}

	@PostMapping("/addDept")
	private ResponseEntity<AppResponse> addDepartment(@Valid@RequestBody DeptAddDto addDept) {
		return new ResponseEntity<>(
				AppResponse.builder().error(false).data(Arrays.asList(serviceInterface.addDept(addDept))).status(200)
						.msg("DATA UPDATED SUCCESFULLY").build(),
				HttpStatus.CREATED);
	}

	@PutMapping("/updateDept")
	private ResponseEntity<AppResponse> updateDepartment(@Valid@RequestBody UpdateDeptDto addDept) {
		serviceInterface.addUpdate(addDept);
		return new ResponseEntity<>(AppResponse.builder().error(false).status(200).msg("DEPARTMENT UPDATED").build(),
				HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteDept/{deptName}")
	private ResponseEntity<AppResponse> deleteDept(@Valid@PathVariable String deptName) {
		serviceInterface.deleteDept(deptName);
		return new ResponseEntity<>(AppResponse.builder().error(false).status(200).msg("DEPARTMENT DELETED SUCESSFULLY").build(),
				HttpStatus.CREATED);
	}


	@PostMapping("/logout")
	public ResponseEntity<AppResponse> logout(@RequestParam String username ) {
		String token=serviceInterface.getTokenFromDb(username);
		if (jwtUtil.makeTokenAsExpired(token)) {
			appResponse.setError(false);
			appResponse.setMsg("LogOut successful");
			appResponse.setStatus(200);
		}
		return new ResponseEntity<>(appResponse, HttpStatus.ACCEPTED);
	}
}
