package com.te.pcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.entity.Departments;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments,Integer>{
}
