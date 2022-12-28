package com.te.pcmjwt.dto;

import com.te.pcmjwt.entity.Departments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterDto {

	private Integer employeeId;
	private String employeeName;
	private String designation;
	private String password;
	private String email;
	private Departments department;
}
