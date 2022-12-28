package com.te.pcmjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.pcmjwt.entity.Departments;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Departments,Integer>{

}
