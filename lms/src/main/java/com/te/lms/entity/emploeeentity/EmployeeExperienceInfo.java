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
public class EmployeeExperienceInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeExperienceInfoId;
	private String employeeCompanyname;
	private String employeeYoe;
	private String employeeJoining;
	private String employeeRelieving;
	private String employeeDesignation;
	private String employeeLocation;
	
}
