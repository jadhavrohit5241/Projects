package com.te.micro.driverservice.dto;

import com.te.micro.driverservice.entity.DriverInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverInfoDto {
	private Integer driverId;
	private String driverName;
	private String driverAddress;
	private String driverContactNo;
	private String driverVehicalDeatils;

	public DriverInfoDto(DriverInfo driverInfo) {
		this.driverAddress = driverInfo.getDriverAddress();
		this.driverContactNo = driverInfo.getDriverContactNo();
		this.driverName = driverInfo.getDriverName();
		this.driverVehicalDeatils = driverInfo.getDriverVehicalDeatils();
		this.driverId = driverInfo.getDriverId();
	}

}
