package com.te.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.emploeeentity.EmployeeEducationInfo;

@Repository
public interface EmployeeEducationInfoRepository extends JpaRepository<EmployeeEducationInfo, Integer> {
	@Query("SELECT COUNT(*) FROM EmployeeEducationInfo  GROUP BY employeeYop")
	List<Long> countEmployeeYop();

	@Query("SELECT COUNT(*) FROM EmployeeEducationInfo  GROUP BY employeeSpecialization")
	String countEmployeeDegree();

}
