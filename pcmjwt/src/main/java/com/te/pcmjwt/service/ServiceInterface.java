package com.te.pcmjwt.service;

import java.util.List;
import java.util.Optional;

import com.te.pcmjwt.dto.EmployeeRegisterDto;
import com.te.pcmjwt.dto.GetAllEmployeeDto;

public interface ServiceInterface {

	boolean register(EmployeeRegisterDto employeeRegisterDto);

	Optional<List<GetAllEmployeeDto>> getAllEmployee();

	//boolean assignRole(AssignRoleDto assignRoleDto);

}
