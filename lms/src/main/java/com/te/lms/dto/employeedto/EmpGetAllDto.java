package com.te.lms.dto.employeedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class EmpGetAllDto {
	private Integer employeeId;
	private String employeeName;
	private String employeeEmailId;
	private String employeeStatus;
	private String employeeRole;

	
}
