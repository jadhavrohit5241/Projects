package com.te.pcmjwt.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.te.pcmjwt.entity.Departments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterDto {

	private Integer employeeId;
	@NotEmpty
	private String employeeName;
	@NotEmpty
	private String designation;
	@NotEmpty(message = "ENTER PASSWORD")
	private String password;
	@Email(message = "EMAIL INVALID")
	private String email;
	@NotNull
	private Departments department;
}
