package com.te.lms.service.employeeservice.employeeserviceimplementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.te.lms.repository.EmployeBankDetailsRepository;
import com.te.lms.repository.EmployeeAddressInfoRepository;
import com.te.lms.repository.EmployeeContactInfoRepository;
import com.te.lms.repository.EmployeeEducationInfoRepository;
import com.te.lms.repository.EmployeeExperianceInfoRepository;
import com.te.lms.repository.EmployeeRepository;
import com.te.lms.repository.EmployeeSecondaryInfoRepository;
import com.te.lms.repository.EmployeeTechnicalSkillRepository;
import com.te.lms.service.employeeservice.employeeserviceinterface.EmployeeServiceInterface;

@Service
public class EmployeeServiceImplementation implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeSecondaryInfoRepository employeeSecondaryRepository;

	@Autowired
	private EmployeeTechnicalSkillRepository employeeTechnicalSkillRepository;

	@Autowired
	private EmployeeExperianceInfoRepository employeeExperienceRepository;

	@Autowired
	private EmployeeEducationInfoRepository employeeEductionRepository;

	@Autowired
	private EmployeBankDetailsRepository employeeBankRepository;

	@Autowired
	private EmployeeAddressInfoRepository employeeAddressRepository;

	@Autowired
	private EmployeeContactInfoRepository employeeContantRepository;

	@Override
	public EmployeePrimaryInfo login(LoginDto dto) throws InvalidPasswordException {

		EmployeePrimaryInfo employeePrimaryInfo = employeeRepository.findById(dto.getEmpId()).orElse(null);
		if (employeePrimaryInfo != null) {

			if (employeePrimaryInfo.getEmployeePass().equals(employeePrimaryInfo.getEmployeePass())) {
				return employeePrimaryInfo;
			} else {
				throw new InvalidPasswordException("Password Mismatch");
			}
		} else {
			throw new InvalidPasswordException("Inavlid UserId");
		}
	}

	@Override
	public EmployeePrimaryInfo resetPass(RestPass restPass) {
		EmployeePrimaryInfo employeePrimaryInfo = employeeRepository.findById(restPass.getEmpId()).orElse(null);
		if (employeePrimaryInfo != null) {
			if ((restPass.getOldPass().equals(employeePrimaryInfo.getEmployeePass()))) {
				employeePrimaryInfo.setEmployeePass(restPass.getConfirmPass());
				return employeeRepository.save(employeePrimaryInfo);
			} else {
				throw new InvalidPasswordException("Password Mismatch");
			}
		} else {

			throw new InvalidPasswordException("Inavlid UserId");
		}
	}

	@Override
	public EmployeePrimaryInfo register(RegisterDto dto) {
		EmployeePrimaryInfo employeeTemp = new EmployeePrimaryInfo();
		BeanUtils.copyProperties(dto, employeeTemp);
		employeeTemp.setEmployeePass(dto.getEmployeeName() + otp());
		// employeeTemp.setBatchId(101);
		// default batch while adding or before Admin clear request
		return employeeRepository.save(employeeTemp);

	}

	@Override
	public EmployeePrimaryInfo update(EmpUpdateDto empUpdateDto) {
		EmployeePrimaryInfo employeeTemp = employeeRepository.findById(empUpdateDto.getEmployeeId()).orElse(null);
		if (employeeTemp != null) {
			BeanUtils.copyProperties(empUpdateDto, employeeTemp);
			return employeeRepository.save(employeeTemp);
		} else {
			throw new InvalidPasswordException("Inavlid UserId");
		}
	}

	@Override
	public boolean delete(FetchDto deleteDto) {
		EmployeePrimaryInfo employeePrimaryInfo = employeeRepository.findById(deleteDto.getEmployeeId()).orElse(null);
		if (employeePrimaryInfo != null) {
			employeeRepository.deleteById(employeePrimaryInfo.getEmployeeId());
			return true;
		} else {

			throw new InvalidPasswordException("Inavlid UserId");
		}
	}

	@Override
	public EmployeePrimaryInfo search(FetchDto search) {
		EmployeePrimaryInfo employeePrimaryInfo = employeeRepository.findById(search.getEmployeeId()).orElse(null);
		if (employeePrimaryInfo != null) {
			employeeRepository.deleteById(employeePrimaryInfo.getEmployeeId());
			return employeePrimaryInfo;
		} else {
			throw new InvalidPasswordException("Inavlid UserId");
		}
	}

	@Override
	public EmployeeSecondaryInfo updateSecondaryInfo(EmpSecondInfoDto empUpdateDto) {
		EmployeeSecondaryInfo employeeTemp = employeeSecondaryRepository.findById(empUpdateDto.getEmployeeId())
				.orElse(null);
		if (employeeTemp != null) {
			BeanUtils.copyProperties(empUpdateDto, employeeTemp);
			return employeeSecondaryRepository.save(employeeTemp);
		} else {
			throw new InvalidPasswordException("Inavlid UserId");
		}
	}

	@Override
	public EmployeeAddressInfo updateUpdateAddressInfo(EmpAddressDto empUpdateDto) {
		EmployeeAddressInfo employeeTemp = employeeAddressRepository.findById(empUpdateDto.getEmployeeId())
				.orElse(null);
		if (employeeTemp != null) {
			BeanUtils.copyProperties(empUpdateDto, employeeTemp);
			return employeeAddressRepository.save(employeeTemp);
		} else {
			throw new InvalidPasswordException("Inavlid UserId");
		}
	}

	@Override
	public EmployeeContactInfo updateConatactInfo(EmpContactInfoDto empUpdateDto) {
		EmployeeContactInfo employeeTemp = employeeContantRepository.findById(empUpdateDto.getEmployeeId())
				.orElse(null);
		if (employeeTemp != null) {
			BeanUtils.copyProperties(empUpdateDto, employeeTemp);
			return employeeContantRepository.save(employeeTemp);
		} else {

			throw new InvalidPasswordException("Inavlid UserId");
		}
	}

	@Override
	public EmployeeBankInfo UpdateBankInfo(EmpBankInfoDto empUpdateDto) {
		EmployeeBankInfo employeeTemp = employeeBankRepository.findById(empUpdateDto.getEmployeeId()).orElse(null);
		if (employeeTemp != null) {
			BeanUtils.copyProperties(empUpdateDto, employeeTemp);
			return employeeBankRepository.save(employeeTemp);
		} else {

			throw new InvalidPasswordException("Inavlid UserId");
		}
	}

	@Override
	public EmployeeExperienceInfo updateExperianceInfo(EmpExpDto empUpdateDto) {
		EmployeeExperienceInfo employeeTemp = employeeExperienceRepository.findById(empUpdateDto.getEmployeeId())
				.orElse(null);
		if (employeeTemp != null) {
			BeanUtils.copyProperties(empUpdateDto, employeeTemp);
			return employeeExperienceRepository.save(employeeTemp);
		} else {
			throw new InvalidPasswordException("Inavlid UserId");
		}
	}

	@Override
	public EmployeeEducationInfo updateEduInfo(EmpEduInfoDto empUpdateDto) {
		EmployeeEducationInfo employeeTemp = employeeEductionRepository.findById(empUpdateDto.getEmployeeId())
				.orElse(null);
		if (employeeTemp != null) {
			BeanUtils.copyProperties(empUpdateDto, employeeTemp);
			return employeeEductionRepository.save(employeeTemp);
		} else {
			try {
				throw new InvalidPasswordException("Inavlid UserId");
			} catch (InvalidPasswordException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public EmployeeTechnicalskillInfo updateTechInfo(EmpTechSkillInfoDTo empUpdateDto) {
		EmployeeTechnicalskillInfo employeeTemp = employeeTechnicalSkillRepository
				.findById(empUpdateDto.getEmployeeId()).orElse(null);
		if (employeeTemp != null) {
			BeanUtils.copyProperties(empUpdateDto, employeeTemp);
			return employeeTechnicalSkillRepository.save(employeeTemp);
		} else {
			try {
				throw new InvalidPasswordException("Inavlid UserId");
			} catch (InvalidPasswordException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static int otp() {
		double det = 99999999 * Math.random() + 99999999;
		int res1 = (int) det;
		return res1;

	}
}
