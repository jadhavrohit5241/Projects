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
public class EmployeeTechnicalskillInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeTechnicalskillInfo;
	private String employeeSkilltype;
	private String employeeSkillRating;

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

}
