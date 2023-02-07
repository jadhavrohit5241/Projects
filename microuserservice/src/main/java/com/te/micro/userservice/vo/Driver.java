package com.te.micro.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Driver {

	private Integer driverId;
	private String driverName;
	private String driverAddress;
	private String driverContactNo;
	private String driverVehicalDeatils;
}
