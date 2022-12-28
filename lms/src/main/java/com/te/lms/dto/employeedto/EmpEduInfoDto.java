package com.te.lms.dto.employeedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class EmpEduInfoDto {
	private Integer employeeEducationInfo;
	private Integer employeeId;
	private String employeeEducationtype;
	private String employeeYop;
	private String employeePercentage;
	private String employeeUniversityname;
	private String employeeInstitutename;
	private String employeeSpecialization;
	private String employeeState;

	public Integer getEmployeeEducationInfo() {
		return employeeEducationInfo;
	}

	public void setEmployeeEducationInfo(Integer employeeEducationInfo) {
		this.employeeEducationInfo = employeeEducationInfo;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeEducationtype() {
		return employeeEducationtype;
	}

	public void setEmployeeEducationtype(String employeeEducationtype) {
		this.employeeEducationtype = employeeEducationtype;
	}

	public String getEmployeeYop() {
		return employeeYop;
	}

	public void setEmployeeYop(String employeeYop) {
		this.employeeYop = employeeYop;
	}

	public String getEmployeePercentage() {
		return employeePercentage;
	}

	public void setEmployeePercentage(String employeePercentage) {
		this.employeePercentage = employeePercentage;
	}

	public String getEmployeeUniversityname() {
		return employeeUniversityname;
	}

	public void setEmployeeUniversityname(String employeeUniversityname) {
		this.employeeUniversityname = employeeUniversityname;
	}

	public String getEmployeeInstitutename() {
		return employeeInstitutename;
	}

	public void setEmployeeInstitutename(String employeeInstitutename) {
		this.employeeInstitutename = employeeInstitutename;
	}

	public String getEmployeeSpecialization() {
		return employeeSpecialization;
	}

	public void setEmployeeSpecialization(String employeeSpecialization) {
		this.employeeSpecialization = employeeSpecialization;
	}

	public String getEmployeeState() {
		return employeeState;
	}

	public void setEmployeeState(String employeeState) {
		this.employeeState = employeeState;
	}

}
