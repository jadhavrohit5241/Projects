package com.te.lms.dto.batch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
@RequiredArgsConstructor

public class RequestDto {
	private Integer empId;
	private String empName;
	private String empYop;
	private Double empPercentage;
	private int empExperiance;
	private long contactNo;
	private Boolean request;

	

}
