package com.te.securityjwt.dto;

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
}
