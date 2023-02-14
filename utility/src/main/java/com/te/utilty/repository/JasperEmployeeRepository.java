package com.te.utilty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.utilty.entity.JasperEmployeeEntitiy;
@Repository
public interface JasperEmployeeRepository extends JpaRepository<JasperEmployeeEntitiy,Integer> {

}
