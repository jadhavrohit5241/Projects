package com.te.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.emploeeentity.EmployeeSecondaryInfo;

@Repository
public interface EmployeeSecondaryInfoRepository extends JpaRepository<EmployeeSecondaryInfo, Integer> {

}
