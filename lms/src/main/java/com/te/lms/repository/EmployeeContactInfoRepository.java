package com.te.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.emploeeentity.EmployeeContactInfo;
@Repository
public interface EmployeeContactInfoRepository extends JpaRepository<EmployeeContactInfo, Integer> {

}
