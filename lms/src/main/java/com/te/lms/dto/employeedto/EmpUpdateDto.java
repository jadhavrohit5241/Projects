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
public class EmpUpdateDto {

	private Integer employeeId;
	private String employeeName;
	private String employeeDoj;
	private String employeeDob;
	private String employeeEmailId;
	private String employeeBloodGroup;
	private String employeeGender;
	private String employeeNationality;
	private String employeeStatus;
	private EmployeeSecondaryInfo employeeSecondaryInfo;
	private List<EmployeeAddressInfo> employeeAddressInfo;
	private List<EmployeeBankInfo> employeeBankInfos;
	private List<EmployeeContactInfo> employeeContactInfos;
	private List<EmployeeEducationInfo> employeeEducationInfos;
	private List<EmployeeTechnicalskillInfo> employeeTechnicalskillInfos;
	private List<EmployeeExperienceInfo> employeeExperienceInfos;



}
