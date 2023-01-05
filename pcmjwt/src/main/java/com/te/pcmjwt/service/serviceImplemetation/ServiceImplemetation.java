package com.te.pcmjwt.service.serviceimplemetation;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.apache.logging.log4j.util.Supplier;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.te.pcmjwt.dto.AssignRoleDto;
import com.te.pcmjwt.dto.DeptAddDto;
import com.te.pcmjwt.dto.EmployeeRegisterDto;
import com.te.pcmjwt.dto.GetAllEmployeeDto;
import com.te.pcmjwt.dto.UpdateDeptDto;
import com.te.pcmjwt.entity.AppUser;
import com.te.pcmjwt.entity.Departments;
import com.te.pcmjwt.entity.Employee;
import com.te.pcmjwt.entity.Roles;
import com.te.pcmjwt.exceptions.DataNotFoundException;
import com.te.pcmjwt.exceptions.InvalidUserInput;
import com.te.pcmjwt.repository.AppUserRepository;
import com.te.pcmjwt.repository.DepartmentRepository;
import com.te.pcmjwt.repository.EmployeRepository;
import com.te.pcmjwt.repository.RolesRepository;
import com.te.pcmjwt.service.ServiceInterface;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServiceImplemetation implements ServiceInterface {
	@Autowired
	private EmployeRepository employeRepository;

	@Autowired
	private AppUserRepository userRepository;

	@Autowired
	private RolesRepository roleRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public boolean register(EmployeeRegisterDto employeeRegisterDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeRegisterDto, employee);
		Optional<Roles> optional = roleRepository.findByRoleName("ROLE_USER");
		if (optional.isPresent()) {
			Roles roles = optional.get();
			AppUser newUser = AppUser.builder().username(employee.getEmployeeName())
					.password(employeeRegisterDto.getPassword()).build();
			roles.getAppUser().add(newUser);
			newUser.getRoles().add(roles);
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
		throw new InvalidUserInput("User Already exist ");
	}

	@Override
	public Optional<List<GetAllEmployeeDto>> getAllEmployee() {
		List<Employee> employees = employeRepository.findAll();
		List<GetAllEmployeeDto> allEmployeeDtos = Lists.newArrayList();
		employees.stream()
				.forEach(i -> allEmployeeDtos.add(GetAllEmployeeDto.builder().departments(i.getDepartment())
						.designation(i.getDesignation()).email(i.getEmail()).employeeId(i.getEmployeeId())
						.employeeName(i.getEmployeeName()).build()));
		return Optional.ofNullable(allEmployeeDtos);
	}

	@Override
	public Departments addDept(DeptAddDto addDept) {
		if (departmentRepository.findByDepartmentTitleIgnoreCase(addDept.getDepartmentTitle()).isPresent()) {
			throw new InvalidUserInput("DEPARTMENT ALREADY PRESENT");
		}
		return departmentRepository.save(Departments.builder().departmentTitle(addDept.getDepartmentTitle())
				.categoryList(null).employees(null).productList(null).build());
	}

	@Override
	public Boolean addUpdate(UpdateDeptDto updateDept) {
		Departments departments = departmentRepository.findByDepartmentTitleIgnoreCase(updateDept.getDeptName())
				.orElseThrow(() -> new DataNotFoundException("DEPARTMENT NOT PRESENT"));
		departments.setDepartmentTitle(updateDept.getUpadeteDeptName());
		departmentRepository.save(departments);
		return true;
	}

	@Override
	public boolean deleteDept(String deptName) {
		departmentRepository.delete(departmentRepository.findByDepartmentTitleIgnoreCase(deptName)
				.orElseThrow(() -> new DataNotFoundException("DEPARTMENT NOT PRESENT")));
		return true;
	}

//	@Override
//	public boolean assignRole(AssignRoleDto assignRoleDto) {
//		Optional<AppUser> user = userRepository.findByUsername(assignRoleDto.getEmployeeName());
//		Supplier<List<Integer>> supplier = () -> Lists.newArrayList(assignRoleDto.getRoleId());
//		List<Roles> findAllById = roleRepository.findAllById(supplier.get());
//		if (findAllById.isEmpty()) {
//			throw new InvalidUserInput("role not precent");
//		} else {
//			AppUser newUser = AppUser.builder().username(user.get().getUsername()).roles(findAllById)
//					.password((new BCryptPasswordEncoder().encode(user.get().getPassword()))).build();
//			userRepository.delete(user.get());
//			userRepository.save(newUser);
//			return true;
//		}
//	}
}
