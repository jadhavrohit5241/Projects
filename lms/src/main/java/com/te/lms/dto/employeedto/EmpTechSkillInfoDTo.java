package com.te.lms.dto.employeedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
@RequiredArgsConstructor

public class EmpTechSkillInfoDTo {
	private int employeeId;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeTechnicalskillInfo() {
		return employeeTechnicalskillInfo;
	}

	public void setEmployeeTechnicalskillInfo(int employeeTechnicalskillInfo) {
		this.employeeTechnicalskillInfo = employeeTechnicalskillInfo;
	}

	public String getEmployeeSkilltype() {
		return employeeSkilltype;
	}

	public void setEmployeeSkilltype(String employeeSkilltype) {
		this.employeeSkilltype = employeeSkilltype;
	}

	public String getEmployeeSkillRating() {
		return employeeSkillRating;
	}

	public void setEmployeeSkillRating(String employeeSkillRating) {
		this.employeeSkillRating = employeeSkillRating;
	}

	private int employeeTechnicalskillInfo;
	private String employeeSkilltype;
	private String employeeSkillRating;

}
