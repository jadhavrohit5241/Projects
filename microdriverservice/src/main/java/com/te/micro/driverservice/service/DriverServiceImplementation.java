package com.te.micro.driverservice.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.micro.driverservice.custexception.InvalidUserInputException;
import com.te.micro.driverservice.dto.DriverInfoDto;
import com.te.micro.driverservice.entity.DriverInfo;
import com.te.micro.driverservice.repository.DriverRepository;

@Service
public class DriverServiceImplementation implements DriverServiceInterface {

	@Autowired
	private DriverRepository driverRepository;

	@Override
	public DriverInfoDto register(DriverInfoDto driverInfoDto) {
		DriverInfo driverInfo = new DriverInfo();
		BeanUtils.copyProperties(driverInfoDto, driverInfo);
		Optional<DriverInfo> driverInfoDb = driverRepository.findById(driverInfoDto.getDriverId());
		if (!driverInfoDb.isEmpty()) {
			throw new InvalidUserInputException("Already present");
		}
		return new DriverInfoDto(driverRepository.save(driverInfo));
	}

	@Override
	public DriverInfoDto getDriverInfo(Integer driverId) {
		Optional<DriverInfo> driverInfoDb = driverRepository.findById(driverId);
		if (driverInfoDb.isEmpty()) {
			throw new InvalidUserInputException("INVALID DRIVER ID");
		}
		return new DriverInfoDto(driverInfoDb.get());
	}
}
