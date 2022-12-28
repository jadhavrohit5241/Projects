package com.te.pcm.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.pcm.appResponse.AppResponse;
import com.te.pcm.dto.AssignRoleDto;
import com.te.pcm.dto.EmployeeRegisterDto;
import com.te.pcm.dto.GetAllEmployeeDto;
import com.te.pcm.service.serviceInterface.ServiceInterface;

@RestController
@RequestMapping(path = "/auth/employee")
public class Controller {
	@Autowired
	private AppResponse appResponse;

	@Autowired
	private ServiceInterface serviceInterface;

	@PostMapping("/register")
	public ResponseEntity<AppResponse> register(@RequestBody EmployeeRegisterDto employeeRegisterDto) {
		if (serviceInterface.register(employeeRegisterDto)) {
			appResponse.setError(false);
			appResponse.setMsg("successful");
			appResponse.setStatus(200);
		}
		return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAllEmployee")
	@PreAuthorize("hasRole('ADMIN')")
	private ResponseEntity<AppResponse> getAllEmployee() {
		Optional<List<GetAllEmployeeDto>> optional = serviceInterface.getAllEmployee();
		if (optional.isPresent()) {
			return new ResponseEntity<AppResponse>(
					AppResponse.builder().Status(200).data(Arrays.asList(optional)).error(false).msg("DATA FOUND").build(),
					HttpStatus.ACCEPTED);
		} else {
			throw new RuntimeException("data not found");
		}

	}
	
	@PutMapping("/asssignRole")
	@PreAuthorize("hasRole('ADMIN')")
	private ResponseEntity<AppResponse>assignRole(@RequestBody AssignRoleDto assignRoleDto){
		if (serviceInterface.assignRole(assignRoleDto)) {
			return new ResponseEntity<AppResponse>(
					AppResponse.builder().Status(200).error(false).msg("ROLE ASSIGNED SUCCESSFULLY").build(),
					HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);	
		}
		
	}
	
}
