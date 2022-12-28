package com.te.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.emploeeentity.EmployeeTechnicalskillInfo;
@Repository
public interface EmployeeTechnicalSkillRepository extends JpaRepository<EmployeeTechnicalskillInfo, Integer> {

}
