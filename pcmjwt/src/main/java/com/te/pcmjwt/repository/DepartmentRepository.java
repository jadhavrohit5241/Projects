package com.te.pcmjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcmjwt.entity.Departments;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments,Integer>{
	Optional<Departments> findByDepartmentTitleIgnoreCase(String departmentTitle);
}
