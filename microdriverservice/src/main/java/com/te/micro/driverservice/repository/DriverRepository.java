package com.te.micro.driverservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.micro.driverservice.entity.DriverInfo;

public interface DriverRepository extends JpaRepository<DriverInfo, Integer> {

}
