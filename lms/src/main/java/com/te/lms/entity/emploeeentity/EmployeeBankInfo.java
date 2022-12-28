package com.te.lms.entity.emploeeentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EmployeeBankInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeBankInfoId;
	private String employeeAccountno;
	private String employeeBankno;
	private String employeeAccounttype;
	private String employeeIFSCcode;
	private String employeeBranch;
	private String employeeState;


	public Integer getEmployeeBankInfo() {
		return employeeBankInfoId;
	}

	public void setEmployeeBankInfo(Integer employeeBankInfo) {
		this.employeeBankInfoId = employeeBankInfo;
	}

	public String getEmployeeAccountno() {
		return employeeAccountno;
	}

	public void setEmployeeAccountno(String employeeAccountno) {
		this.employeeAccountno = employeeAccountno;
	}

	public String getEmployeeBankno() {
		return employeeBankno;
	}

	public void setEmployeeBankno(String employeeBankno) {
		this.employeeBankno = employeeBankno;
	}

	public String getEmployeeAccounttype() {
		return employeeAccounttype;
	}

	public void setEmployeeAccounttype(String employeeAccounttype) {
		this.employeeAccounttype = employeeAccounttype;
	}

	public String getEmployeeIFSCcode() {
		return employeeIFSCcode;
	}

	public void setEmployeeIFSCcode(String employeeIFSCcode) {
		this.employeeIFSCcode = employeeIFSCcode;
	}

	public String getEmployeeBranch() {
		return employeeBranch;
	}

	public void setEmployeeBranch(String employeeBranch) {
		this.employeeBranch = employeeBranch;
	}

	public String getEmployeeState() {
		return employeeState;
	}

	public void setEmployeeState(String employeeState) {
		this.employeeState = employeeState;
	}


}
