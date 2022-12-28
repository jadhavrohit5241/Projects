package com.te.pcm.dto;

import com.te.pcm.entity.Departments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeeDto {
	private Integer employeeId;
	private String employeeName;
	private String designation;
	private String email;
	private Departments departments;
}
