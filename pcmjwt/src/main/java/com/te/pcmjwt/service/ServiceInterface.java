package com.te.pcmjwt.service;

import java.util.List;
import java.util.Optional;

import com.te.pcmjwt.dto.DeptAddDto;
import com.te.pcmjwt.dto.EmployeeRegisterDto;
import com.te.pcmjwt.dto.GetAllEmployeeDto;
import com.te.pcmjwt.dto.UpdateDeptDto;
import com.te.pcmjwt.entity.Departments;

public interface ServiceInterface {

	boolean register(EmployeeRegisterDto employeeRegisterDto);

	Optional<List<GetAllEmployeeDto>> getAllEmployee();

	Departments addDept(DeptAddDto addDept);

	Boolean addUpdate(UpdateDeptDto addDept);

	boolean  deleteDept(String deptName);

	void saveTokenInDatabase(String username, String token);

	String getTokenFromDb(String username);

	//boolean assignRole(AssignRoleDto assignRoleDto);

}
