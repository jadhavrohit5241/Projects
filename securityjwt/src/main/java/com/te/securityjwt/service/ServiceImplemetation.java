package com.te.securityjwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.te.security.exceptions.InvalidUserInput;
import com.te.securityjwt.dto.AssignRoleDto;
import com.te.securityjwt.dto.EmployeeRegisterDto;
import com.te.securityjwt.dto.GetAllEmployeeDto;
import com.te.securityjwt.entity.AppUser;
import com.te.securityjwt.entity.Employee;
import com.te.securityjwt.entity.Roles;
import com.te.securityjwt.repository.AppUserRepository;
import com.te.securityjwt.repository.EmployeeRepository;
import com.te.securityjwt.repository.RolesRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServiceImplemetation implements ServiceInterface {
	@Autowired
	private EmployeeRepository employeRepository;

	@Autowired
	private AppUserRepository userRepository;

	@Autowired
	private RolesRepository roleRepository;

	@Override
	public boolean register(EmployeeRegisterDto employeeRegisterDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeRegisterDto, employee);
		Optional<Roles> optional = roleRepository.findByRoleName("ROLE_USER");
		if (optional.isPresent()) {
			Roles roles = optional.get();
			AppUser newUser = AppUser.builder().username(employee.getUserName())
					.password(new BCryptPasswordEncoder().encode(employeeRegisterDto.getPassword()))
					.roles(Lists.newArrayList()).build();
			roles.getAppUser().add(newUser);
			newUser.getRoles().add(roles);
			userRepository.save(newUser);
			employeRepository.save(employee);
			return true;
		}
		throw new InvalidUserInput("User Already exist ");
	}

	@Override
	public Optional<List<GetAllEmployeeDto>> getAllEmployee() {

		List<Employee> employees = employeRepository.findAll();
		List<GetAllEmployeeDto> allEmployeeDtos = Lists.newArrayList();
		employees.stream().forEach(i -> allEmployeeDtos.add(GetAllEmployeeDto.builder().designation(i.getDesignation())
				.email(i.getEmail()).employeeId(i.getEmployeeId()).employeeName(i.getEmployeeName()).build()));
		return Optional.ofNullable(allEmployeeDtos);
	}

	@Override
	public Optional<Employee> getDetails(String username) {
		Employee findByUserName = employeRepository.findByUserName(username);
		if (findByUserName == null) {
			throw new InvalidUserInput("INVALID USERNAME");
		}
		return Optional.ofNullable(findByUserName);
	}

	@Override
	public Boolean assignRole(AssignRoleDto assignRoleDto) {
		Roles role = roleRepository.findById(assignRoleDto.getRoleId())
				.orElseThrow(() -> new InvalidUserInput("ROLE NOT PRESENT"));
		Optional<AppUser> appUserOptional = userRepository
				.findByUsername((employeRepository.findById(assignRoleDto.getEmployeeId())
						.orElseThrow(() -> new InvalidUserInput("INVALID EMPLOYEE ID"))).getUserName());
		AppUser appUser = appUserOptional.get();
		appUser.getRoles().add(role);
		userRepository.save(appUser);
		return true;
	}

}
