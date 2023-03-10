package com.te.pcmjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcmjwt.entity.Employee;
@Repository
public interface EmployeRepository extends JpaRepository<Employee, Integer> {

}
