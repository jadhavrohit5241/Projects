package com.te.lms.entity.emploeeentity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class EmployeeAddressInfo {
	@Id
	private int employeeAddressInfo;

	private String employeeAddresstype;
	private String employeeDoorno;
	private String employeeStreetno;
	private String employeeLocality;
	private String employeeCity;
	private String employeeState;
	private String employeePincode;
	private String employeeLandmark;

	public int getEmployeeAddressInfo() {
		return employeeAddressInfo;
	}

	public void setEmployeeAddressInfo(int employeeAddressInfo) {
		this.employeeAddressInfo = employeeAddressInfo;
	}

	public String getEmployeeAddresstype() {
		return employeeAddresstype;
	}

	public void setEmployeeAddresstype(String employeeAddresstype) {
		this.employeeAddresstype = employeeAddresstype;
	}

	public String getEmployeeDoorno() {
		return employeeDoorno;
	}

	public void setEmployeeDoorno(String employeeDoorno) {
		this.employeeDoorno = employeeDoorno;
	}

	public String getEmployeeStreetno() {
		return employeeStreetno;
	}

	public void setEmployeeStreetno(String employeeStreetno) {
		this.employeeStreetno = employeeStreetno;
	}

	public String getEmployeeLocality() {
		return employeeLocality;
	}

	public void setEmployeeLocality(String employeeLocality) {
		this.employeeLocality = employeeLocality;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public String getEmployeeState() {
		return employeeState;
	}

	public void setEmployeeState(String employeeState) {
		this.employeeState = employeeState;
	}

	public String getEmployeePincode() {
		return employeePincode;
	}

	public void setEmployeePincode(String employeePincode) {
		this.employeePincode = employeePincode;
	}

	public String getEmployeeLandmark() {
		return employeeLandmark;
	}

	public void setEmployeeLandmark(String employeeLandmark) {
		this.employeeLandmark = employeeLandmark;
	}

}
