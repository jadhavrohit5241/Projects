package com.te.lms.dto.employeedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter

public class EmpSecondInfoDto {
	private int employeeSecondaryInfoId;
	private int employeeId;
	private String employeePanId;
	private int employeeAadharano;
	private String employeeFathername;
	private String employeeMothername;
	private String employeePassportno;
	private String employeeMartialstatus;

	public int getEmployeeSecondaryInfoId() {
		return employeeSecondaryInfoId;
	}

	public void setEmployeeSecondaryInfoId(int employeeSecondaryInfoId) {
		this.employeeSecondaryInfoId = employeeSecondaryInfoId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeePanId() {
		return employeePanId;
	}

	public void setEmployeePanId(String employeePanId) {
		this.employeePanId = employeePanId;
	}

	public int getEmployeeAadharano() {
		return employeeAadharano;
	}

	public void setEmployeeAadharano(int employeeAadharano) {
		this.employeeAadharano = employeeAadharano;
	}

	public String getEmployeeFathername() {
		return employeeFathername;
	}

	public void setEmployeeFathername(String employeeFathername) {
		this.employeeFathername = employeeFathername;
	}

	public String getEmployeeMothername() {
		return employeeMothername;
	}

	public void setEmployeeMothername(String employeeMothername) {
		this.employeeMothername = employeeMothername;
	}

	public String getEmployeePassportno() {
		return employeePassportno;
	}

	public void setEmployeePassportno(String employeePassportno) {
		this.employeePassportno = employeePassportno;
	}

	public String getEmployeeMartialstatus() {
		return employeeMartialstatus;
	}

	public void setEmployeeMartialstatus(String employeeMartialstatus) {
		this.employeeMartialstatus = employeeMartialstatus;
	}

}
