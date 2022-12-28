package com.te.lms.entity.emploeeentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class EmployeeEducationInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeEducationInfo;

	private String employeeEducationtype;
	private String employeeYop;
	private String employeePercentage;
	private String employeeUniversityname;
	private String employeeInstitutename;
	private String employeeSpecialization;
	private String employeeState;
}
