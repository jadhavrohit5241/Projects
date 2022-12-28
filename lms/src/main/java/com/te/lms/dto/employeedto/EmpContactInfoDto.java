package com.te.lms.dto.employeedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter


public class EmpContactInfoDto {
	private int employeeId;
	private int employeeContactInfo;
	private String employeeContacttype;
	private long employeeContactno;
	

}
