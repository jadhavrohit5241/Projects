package com.te.securityjwt.service;

import java.util.List;
import java.util.Optional;

import com.te.securityjwt.dto.AssignRoleDto;
import com.te.securityjwt.dto.EmployeeRegisterDto;
import com.te.securityjwt.dto.GetAllEmployeeDto;
import com.te.securityjwt.entity.Employee;

public interface ServiceInterface {

	boolean register(EmployeeRegisterDto employeeRegisterDto);

	Optional<List<GetAllEmployeeDto>> getAllEmployee();

	Optional<Employee> getDetails(String username);

	Boolean assignRole(AssignRoleDto assignRoleDto);
	
//	void saveTokenInDatabase(String username, String token);

}
