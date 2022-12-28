package com.te.pcmjwt.service.serviceImplemetation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.pcmjwt.dto.AssignRoleDto;
import com.te.pcmjwt.dto.EmployeeRegisterDto;
import com.te.pcmjwt.dto.GetAllEmployeeDto;
import com.te.pcmjwt.entity.Employee;
import com.te.pcmjwt.entity.Role;
import com.te.pcmjwt.entity.User;
import com.te.pcmjwt.exceptions.InvalidUserInput;
import com.te.pcmjwt.repository.EmployeRepository;
import com.te.pcmjwt.repository.RoleRepository;
import com.te.pcmjwt.repository.UserRepository;
import com.te.pcmjwt.service.serviceInterface.ServiceInterface;

@Service
public class ServiceImplemetation implements ServiceInterface {
	@Autowired
	private EmployeRepository employeRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public boolean register(EmployeeRegisterDto employeeRegisterDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeRegisterDto, employee);
		Optional<Role> optional = roleRepository.findByRoleName("USER");
		if (optional.isPresent()) {
			Role role = optional.get();
			User newUser = User.builder().employeeName(employee.getEmployeeName()).role(role)
					.password((new BCryptPasswordEncoder().encode(employeeRegisterDto.getPassword()))).build();
			userRepository.save(newUser);

			/**
			 * Departments department =
			 * departmentRepository.findById(employee.getDepartment().getDepartmentId())
			 * .orElseThrow(() -> new InvalidUserInput("INVALID DEPARTMNET ID"));
			 * 
			 * department.getEmployees().add(employee);
			 * departmentRepository.save(department);
			 **/

			employeRepository.save(employee);
			return true;
		}
		return false;
	}

	@Override
	public Optional<List<GetAllEmployeeDto>> getAllEmployee() {
		List<Employee> employees = employeRepository.findAll();
		List<GetAllEmployeeDto> allEmployeeDtos = new ArrayList<GetAllEmployeeDto>();
		employees.stream()
				.forEach((i) -> allEmployeeDtos.add(GetAllEmployeeDto.builder().departments(i.getDepartment())
						.designation(i.getDesignation()).email(i.getEmail()).employeeId(i.getEmployeeId())
						.employeeName(i.getEmployeeName()).build()));
		return Optional.ofNullable(allEmployeeDtos);
	}

	@Override
	public boolean assignRole(AssignRoleDto assignRoleDto) {
		User user = userRepository.findByEmployeeName(assignRoleDto.getEmployeeName());
		Optional<Role> optional = roleRepository.findById(assignRoleDto.getRoleId());
		if (optional.isPresent()) {
			Role role = optional.get();
			User newUser = User.builder().employeeName(user.getEmployeeName()).role(role)
					.password((new BCryptPasswordEncoder().encode(user.getPassword()))).build();
			userRepository.delete(user);
			userRepository.save(newUser);
//			user.getRole().setRoleId(assignRoleDto.getRoleId());	
			return true;
		}
		throw new InvalidUserInput("role not precent");
	}
}
