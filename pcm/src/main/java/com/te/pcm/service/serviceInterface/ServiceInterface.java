package com.te.pcm.service.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.te.pcm.dto.AssignRoleDto;
import com.te.pcm.dto.EmployeeRegisterDto;
import com.te.pcm.dto.GetAllEmployeeDto;

public interface ServiceInterface {

	boolean register(EmployeeRegisterDto employeeRegisterDto);

	Optional<List<GetAllEmployeeDto>> getAllEmployee();

	boolean assignRole(AssignRoleDto assignRoleDto);

}
