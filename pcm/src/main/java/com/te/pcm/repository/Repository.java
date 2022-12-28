package com.te.pcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.pcm.entity.Departments;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Departments,Integer>{

}
