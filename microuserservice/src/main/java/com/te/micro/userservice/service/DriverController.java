package com.te.micro.userservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.te.micro.userservice.response.AppResponse;

@FeignClient(name = "DRIVER-SERVICE")
public interface DriverController {

	@GetMapping("driver/getDriverInfo/{driverId}")
	public ResponseEntity<AppResponse> getDriverInfo(@PathVariable Integer driverId);

}
