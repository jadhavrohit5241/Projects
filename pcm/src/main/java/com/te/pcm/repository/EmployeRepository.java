package com.te.pcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.entity.Employee;
@Repository
public interface EmployeRepository extends JpaRepository<Employee, Integer> {

}
