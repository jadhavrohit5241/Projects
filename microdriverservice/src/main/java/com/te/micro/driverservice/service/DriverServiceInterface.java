package com.te.micro.driverservice.service;

import com.te.micro.driverservice.dto.DriverInfoDto;

public interface DriverServiceInterface {

	DriverInfoDto register(DriverInfoDto driverInfoDto);

	DriverInfoDto getDriverInfo(Integer driverId);

}
