package com.te.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.emploeeentity.EmployeePrimaryInfo;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeePrimaryInfo, Integer> {

	@Query("SELECT COUNT(*) FROM EmployeePrimaryInfo GROUP BY employeeGender")
	List<Long> countGender();
}
