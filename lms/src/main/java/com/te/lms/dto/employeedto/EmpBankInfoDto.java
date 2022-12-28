package com.te.lms.dto.employeedto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter

public class EmpBankInfoDto {
	 private int employeeId;
	private int employeeBankInfoId;
	private String employeeAccountno;
	private String employeeBankno;
	private String employeeAccounttype;
	private String employeeIFSCcode;
	private String employeeBranch;
	private String employeeState;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getEmployeeBankInfoId() {
		return employeeBankInfoId;
	}
	public void setEmployeeBankInfoId(int employeeBankInfoId) {
		this.employeeBankInfoId = employeeBankInfoId;
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
