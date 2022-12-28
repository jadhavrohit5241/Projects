package com.te.lms.service.employeeservice.employeeserviceinterface;

import org.springframework.stereotype.Service;

import com.te.lms.dto.employeedto.EmpAddressDto;
import com.te.lms.dto.employeedto.EmpBankInfoDto;
import com.te.lms.dto.employeedto.EmpContactInfoDto;
import com.te.lms.dto.employeedto.EmpEduInfoDto;
import com.te.lms.dto.employeedto.EmpExpDto;
import com.te.lms.dto.employeedto.EmpSecondInfoDto;
import com.te.lms.dto.employeedto.EmpTechSkillInfoDTo;
import com.te.lms.dto.employeedto.EmpUpdateDto;
import com.te.lms.dto.employeedto.FetchDto;
import com.te.lms.dto.employeedto.LoginDto;
import com.te.lms.dto.employeedto.RegisterDto;
import com.te.lms.dto.employeedto.RestPass;
import com.te.lms.entity.emploeeentity.EmployeeAddressInfo;
import com.te.lms.entity.emploeeentity.EmployeeBankInfo;
import com.te.lms.entity.emploeeentity.EmployeeContactInfo;
import com.te.lms.entity.emploeeentity.EmployeeEducationInfo;
import com.te.lms.entity.emploeeentity.EmployeeExperienceInfo;
import com.te.lms.entity.emploeeentity.EmployeePrimaryInfo;
import com.te.lms.entity.emploeeentity.EmployeeSecondaryInfo;
import com.te.lms.entity.emploeeentity.EmployeeTechnicalskillInfo;
import com.te.lms.exception.InvalidPasswordException;

@Service
public interface EmployeeServiceInterface {

	EmployeePrimaryInfo login(LoginDto dto) throws InvalidPasswordException;

	EmployeePrimaryInfo resetPass(RestPass restPass);

	EmployeePrimaryInfo register(RegisterDto dto);

	EmployeePrimaryInfo update(EmpUpdateDto empUpdateDto);

	EmployeePrimaryInfo search(FetchDto search);

	boolean delete(FetchDto deleteDto);

	EmployeeSecondaryInfo updateSecondaryInfo(EmpSecondInfoDto empUpdateDto);

	EmployeeAddressInfo updateUpdateAddressInfo(EmpAddressDto empUpdateDto);

	EmployeeContactInfo updateConatactInfo(EmpContactInfoDto empUpdateDto);

	EmployeeBankInfo UpdateBankInfo(EmpBankInfoDto empUpdateDto);

	EmployeeExperienceInfo updateExperianceInfo(EmpExpDto empUpdateDto);

	EmployeeEducationInfo updateEduInfo(EmpEduInfoDto empUpdateDto);

	EmployeeTechnicalskillInfo updateTechInfo(EmpTechSkillInfoDTo empUpdateDto);

}
