package com.te.pcmjwt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.pcmjwt.appresponse.AppResponse;
import com.te.pcmjwt.dto.AssignRoleDto;
import com.te.pcmjwt.dto.EmployeeRegisterDto;
import com.te.pcmjwt.dto.GetAllEmployeeDto;
import com.te.pcmjwt.service.ServiceInterface;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth/employee")
public class AppController {
	@Autowired
	private AppResponse appResponse;

	private final ServiceInterface serviceInterface;

//	@Autowired
//	private JwtUtil jwtUtil;

//	@Autowired
//	private final AuthenticationManager authenticationManager;
//
//	@PostMapping("/token")
//	private ResponseEntity<AppResponse> generateToken(@RequestBody JwtDto dto) {
//		try {
//			this.authenticationManager
//					.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
//		} catch (UsernameNotFoundException exception) {
//
//			throw new UserNotFoundException("Invalid User ID");
//		}
//		String token = jwtUtil.generateToken(dto.getUsername());
//		return new ResponseEntity<>(
//				AppResponse.builder().status(200).data(Arrays.asList(token)).msg("token created").error(false).build(),
//				HttpStatus.ACCEPTED);
//	}

	@PostMapping("/register")
	public ResponseEntity<AppResponse> register(@RequestBody EmployeeRegisterDto employeeRegisterDto) {
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
			return new ResponseEntity<>(AppResponse.builder().status(200).data(Arrays.asList(optional))
					.error(false).msg("DATA FOUND").build(), HttpStatus.ACCEPTED);
		} else {
			throw new RuntimeException("data not found");
		}

	}

//	@PutMapping("/asssignRole")
//	//@PreAuthorize("hasRole('ADMIN')")
//	private ResponseEntity<AppResponse> assignRole(@RequestBody AssignRoleDto assignRoleDto) {
//		if (serviceInterface.assignRole(assignRoleDto)) {
//			return new ResponseEntity<>(
//					AppResponse.builder().status(200).error(false).msg("ROLE ASSIGNED SUCCESSFULLY").build(),
//					HttpStatus.ACCEPTED);
//		} else {
//			return new ResponseEntity<>(appResponse, HttpStatus.ACCEPTED);
//		}
//
//	}

}
