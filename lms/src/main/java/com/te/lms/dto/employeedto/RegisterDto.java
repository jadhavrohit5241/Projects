package com.te.lms.dto.employeedto;

import java.util.List;

import com.te.lms.entity.emploeeentity.EmployeeAddressInfo;
import com.te.lms.entity.emploeeentity.EmployeeBankInfo;
import com.te.lms.entity.emploeeentity.EmployeeContactInfo;
import com.te.lms.entity.emploeeentity.EmployeeEducationInfo;
import com.te.lms.entity.emploeeentity.EmployeeExperienceInfo;
import com.te.lms.entity.emploeeentity.EmployeeSecondaryInfo;
import com.te.lms.entity.emploeeentity.EmployeeTechnicalskillInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter	

public class RegisterDto {

	private Integer employeeId;
	private String employeeName;
	private String employeeDoj;
	private String employeeDob;

	private String employeeEmailId;
	private String employeeBloodGroup;
	private String employeeGender;

	private String employeeNationality;
	private String employeeStatus;

	private String employeeRole;

	private String employeePass;

	private EmployeeSecondaryInfo employeeSecondaryInfo;
	private List<EmployeeAddressInfo> employeeAddressInfo;
	private List<EmployeeBankInfo> employeeBankInfos;

	private List<EmployeeContactInfo> employeeContactInfos;

	private List<EmployeeEducationInfo> employeeEducationInfos;

	private List<EmployeeTechnicalskillInfo> employeeTechnicalskillInfos;

	private List<EmployeeExperienceInfo> employeeExperienceInfos;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDoj() {
		return employeeDoj;
	}

	public void setEmployeeDoj(String employeeDoj) {
		this.employeeDoj = employeeDoj;
	}

	public String getEmployeeDob() {
		return employeeDob;
	}

	public void setEmployeeDob(String employeeDob) {
		this.employeeDob = employeeDob;
	}

	public String getEmployeeEmailId() {
		return employeeEmailId;
	}

	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}

	public String getEmployeeBloodGroup() {
		return employeeBloodGroup;
	}

	public void setEmployeeBloodGroup(String employeeBloodGroup) {
		this.employeeBloodGroup = employeeBloodGroup;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeeNationality() {
		return employeeNationality;
	}

	public void setEmployeeNationality(String employeeNationality) {
		this.employeeNationality = employeeNationality;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public String getEmployeePass() {
		return employeePass;
	}

	public void setEmployeePass(String employeePass) {
		this.employeePass = employeePass;
	}

	public EmployeeSecondaryInfo getEmployeeSecondaryInfo() {
		return employeeSecondaryInfo;
	}

	public void setEmployeeSecondaryInfo(EmployeeSecondaryInfo employeeSecondaryInfo) {
		this.employeeSecondaryInfo = employeeSecondaryInfo;
	}

	public List<EmployeeAddressInfo> getEmployeeAddressInfo() {
		return employeeAddressInfo;
	}

	public void setEmployeeAddressInfo(List<EmployeeAddressInfo> employeeAddressInfo) {
		this.employeeAddressInfo = employeeAddressInfo;
	}

	public List<EmployeeBankInfo> getEmployeeBankInfos() {
		return employeeBankInfos;
	}

	public void setEmployeeBankInfos(List<EmployeeBankInfo> employeeBankInfos) {
		this.employeeBankInfos = employeeBankInfos;
	}

	public List<EmployeeContactInfo> getEmployeeContactInfos() {
		return employeeContactInfos;
	}

	public void setEmployeeContactInfos(List<EmployeeContactInfo> employeeContactInfos) {
		this.employeeContactInfos = employeeContactInfos;
	}

	public List<EmployeeEducationInfo> getEmployeeEducationInfos() {
		return employeeEducationInfos;
	}

	public void setEmployeeEducationInfos(List<EmployeeEducationInfo> employeeEducationInfos) {
		this.employeeEducationInfos = employeeEducationInfos;
	}

	public List<EmployeeTechnicalskillInfo> getEmployeeTechnicalskillInfos() {
		return employeeTechnicalskillInfos;
	}

	public void setEmployeeTechnicalskillInfos(List<EmployeeTechnicalskillInfo> employeeTechnicalskillInfos) {
		this.employeeTechnicalskillInfos = employeeTechnicalskillInfos;
	}

	public List<EmployeeExperienceInfo> getEmployeeExperienceInfos() {
		return employeeExperienceInfos;
	}

	public void setEmployeeExperienceInfos(List<EmployeeExperienceInfo> employeeExperienceInfos) {
		this.employeeExperienceInfos = employeeExperienceInfos;
	}

}
