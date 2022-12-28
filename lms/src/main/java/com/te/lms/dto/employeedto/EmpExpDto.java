package com.te.lms.dto.employeedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class EmpExpDto {
	private int employeeId;
	private int employeeExperienceInfoId;
	private String employeeCompanyname;
	private String employeeYoe;
	private String employeeJoining;
	private String employeeRelieving;
	private String employeeDesignation;
	private String employeeLocation;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getEmployeeExperienceInfoId() {
		return employeeExperienceInfoId;
	}
	public void setEmployeeExperienceInfoId(int employeeExperienceInfoId) {
		this.employeeExperienceInfoId = employeeExperienceInfoId;
	}
	public String getEmployeeCompanyname() {
		return employeeCompanyname;
	}
	public void setEmployeeCompanyname(String employeeCompanyname) {
		this.employeeCompanyname = employeeCompanyname;
	}
	public String getEmployeeYoe() {
		return employeeYoe;
	}
	public void setEmployeeYoe(String employeeYoe) {
		this.employeeYoe = employeeYoe;
	}
	public String getEmployeeJoining() {
		return employeeJoining;
	}
	public void setEmployeeJoining(String employeeJoining) {
		this.employeeJoining = employeeJoining;
	}
	public String getEmployeeRelieving() {
		return employeeRelieving;
	}
	public void setEmployeeRelieving(String employeeRelieving) {
		this.employeeRelieving = employeeRelieving;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public String getEmployeeLocation() {
		return employeeLocation;
	}
	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}
	

}
