package com.te.micro.driverservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverInfo implements Serializable {

	@Id
	private Integer driverId;
	private String driverName;
	private String driverAddress;
	private String driverContactNo;
	
	private String driverVehicalDeatils;
	
	
}
