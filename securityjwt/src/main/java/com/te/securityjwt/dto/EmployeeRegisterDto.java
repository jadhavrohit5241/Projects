package com.te.securityjwt.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterDto {
	@NotEmpty
	private String employeeName;
	@NotEmpty
	private String userName;
	@NotEmpty
	private String designation;
	@NotEmpty(message = "ENTER PASSWORD")
	private String password;
	@Email(message = "EMAIL INVALID")
	private String email;

}
