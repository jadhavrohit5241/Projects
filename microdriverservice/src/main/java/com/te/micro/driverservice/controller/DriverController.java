package com.te.micro.driverservice.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.micro.driverservice.dto.DriverInfoDto;
import com.te.micro.driverservice.response.AppResponse;
import com.te.micro.driverservice.service.DriverServiceInterface;

@RestController
@RequestMapping("/driver")
public class DriverController {
	@Autowired
	private DriverServiceInterface driverServiceInterface;

	@PostMapping("/register")
	public ResponseEntity<AppResponse> upload(@RequestBody DriverInfoDto driverInfoDto) {
		return ResponseEntity.ok(AppResponse.builder().status(200).msg("Data saved in DataBase")
				.data((driverServiceInterface.register(driverInfoDto)))
				.timestamp(LocalDate.now().toString()).error(false).build());

	}
	
	@GetMapping("/getDriverInfo/{driverId}")
	public ResponseEntity<AppResponse> getDriverInfo(@PathVariable Integer driverId) {
		return ResponseEntity.ok(AppResponse.builder().status(200).msg("Data saved in DataBase")
				.data((driverServiceInterface.getDriverInfo(driverId)))
				.timestamp(LocalDate.now().toString()).error(false).build());

	}

}
