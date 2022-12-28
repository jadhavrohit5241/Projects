package com.te.lms.controller.employeecontroller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.te.lms.appresponse.AppResponse;
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
import com.te.lms.service.employeeservice.employeeserviceinterface.EmployeeServiceInterface;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private AppResponse appResponse;

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;

	@PostMapping("/login")
	private ResponseEntity<AppResponse> login(@RequestBody LoginDto dto) throws InvalidPasswordException {

		EmployeePrimaryInfo employeePrimaryInfo = employeeServiceInterface.login(dto);
		if (employeePrimaryInfo != null) {
			if (employeePrimaryInfo.getEmployeeRole().equalsIgnoreCase("ADMIN")) {
				appResponse.setError(false);
				appResponse.setMsg("Admin login successful ");
				appResponse.setStatus(200);
				appResponse.setData(Arrays.asList());
				return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
			} else if (employeePrimaryInfo.getEmployeeRole().equalsIgnoreCase("MENTOR")) {
				appResponse.setError(false);
				appResponse.setMsg("Mentor login successful ");
				appResponse.setStatus(200);
				appResponse.setData(Arrays.asList());
				return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
			} else {
				appResponse.setError(false);
				appResponse.setMsg("Employee login successful ");
				appResponse.setStatus(200);
				appResponse.setData(Arrays.asList(employeePrimaryInfo));
				return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

			}
		} else {
			appResponse.setError(false);
			appResponse.setMsg(" login failed ");
			appResponse.setStatus(401);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.UNAUTHORIZED);

		}
	}

	@PostMapping("/resetPass")
	private ResponseEntity<AppResponse> login(@RequestBody RestPass restPass) {
		EmployeePrimaryInfo employeePrimaryInfo = employeeServiceInterface.resetPass(restPass);
		if (employeePrimaryInfo != null) {
			appResponse.setError(false);
			appResponse.setMsg("password reset successful ");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(false);
			appResponse.setMsg("wrong password");
			appResponse.setStatus(401);
			
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/register")
	private ResponseEntity<AppResponse> addData(@RequestBody RegisterDto dto) {
		EmployeePrimaryInfo employeePrimaryInfoTemp = employeeServiceInterface.register(dto);
		if (employeePrimaryInfoTemp != null) {
			appResponse.setError(false);
			appResponse.setMsg("successful");
			appResponse.setStatus(200);
			appResponse.setData(Arrays.asList(employeePrimaryInfoTemp));
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
		return null;
	}

	@PutMapping("/update")
	private ResponseEntity<AppResponse> update(@RequestBody EmpUpdateDto empUpdateDto) {
		EmployeePrimaryInfo employeePrimaryInfoTemp = employeeServiceInterface.update(empUpdateDto);
		if (employeePrimaryInfoTemp != null) {
			appResponse.setData(Arrays.asList(employeePrimaryInfoTemp));
			appResponse.setError(false);
			appResponse.setMsg("data updated sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}

	}

	@DeleteMapping("/delete")
	private ResponseEntity<AppResponse> delete(@RequestBody FetchDto deleteDto) {
		if (employeeServiceInterface.delete(deleteDto)) {
			appResponse.setError(false);
			appResponse.setMsg("data deleted sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@PostMapping("/search")
	private ResponseEntity<AppResponse> search(@RequestBody FetchDto search) {
		EmployeePrimaryInfo employee2 = employeeServiceInterface.search(search);
		if (employee2 != null) {
			appResponse.setData(employee2);
			appResponse.setError(false);
			appResponse.setMsg("data deleted sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@PutMapping("/updateSecondary")
	private ResponseEntity<AppResponse> updateSecondaryInfo(@RequestBody EmpSecondInfoDto empUpdateDto) {
		EmployeeSecondaryInfo employeeSecondaryInfo = employeeServiceInterface.updateSecondaryInfo(empUpdateDto);
		if (employeeSecondaryInfo != null) {
			appResponse.setData(Arrays.asList(employeeSecondaryInfo));
			appResponse.setError(false);
			appResponse.setMsg("data updated sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}

	}

	@PutMapping("/updateAddress")
	private ResponseEntity<AppResponse> updateUpdateAddressInfo(@RequestBody EmpAddressDto empUpdateDto) {
		EmployeeAddressInfo addressInfo = employeeServiceInterface.updateUpdateAddressInfo(empUpdateDto);
		if (addressInfo != null) {
			appResponse.setData(Arrays.asList(addressInfo));
			appResponse.setError(false);
			appResponse.setMsg("data updated sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}

	}

	@PutMapping("/updateBank")
	private ResponseEntity<AppResponse> UpdateBankInfo(@RequestBody EmpBankInfoDto empUpdateDto) {
		EmployeeBankInfo info = employeeServiceInterface.UpdateBankInfo(empUpdateDto);
		if (info != null) {
			appResponse.setData(Arrays.asList(info));
			appResponse.setError(false);
			appResponse.setMsg("data updated sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}

	}

	@PutMapping("/updateConatct")
	private ResponseEntity<AppResponse> updateConatactInfo(@RequestBody EmpContactInfoDto empUpdateDto) {
		EmployeeContactInfo info = employeeServiceInterface.updateConatactInfo(empUpdateDto);
		if (info != null) {
			appResponse.setData(Arrays.asList(info));
			appResponse.setError(false);
			appResponse.setMsg("data updated sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}

	}

	@PutMapping("/updateEdu")
	private ResponseEntity<AppResponse> updateEduInfo(@RequestBody EmpEduInfoDto empUpdateDto) {
		EmployeeEducationInfo info = employeeServiceInterface.updateEduInfo(empUpdateDto);
		if (info != null) {
			appResponse.setData(Arrays.asList(info));
			appResponse.setError(false);
			appResponse.setMsg("data updated sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}

	}

	@PutMapping("/updateExperianceInfo")
	private ResponseEntity<AppResponse> updateExperianceInfo(@RequestBody EmpExpDto empUpdateDto) {
		EmployeeExperienceInfo info = employeeServiceInterface.updateExperianceInfo(empUpdateDto);
		if (info != null) {
			appResponse.setData(Arrays.asList(info));
			appResponse.setError(false);
			appResponse.setMsg("data updated sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}

	}

	@PutMapping("/updateTechInfo")
	private ResponseEntity<AppResponse> updateTechInfo(@RequestBody EmpTechSkillInfoDTo empUpdateDto) {
		EmployeeTechnicalskillInfo info = employeeServiceInterface.updateTechInfo(empUpdateDto);
		if (info != null) {
			appResponse.setData(Arrays.asList(info));
			appResponse.setError(false);
			appResponse.setMsg("data updated sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}

	}
}
