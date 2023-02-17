package com.te.jasperdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.jasperdemo.entity.CustomerInfo;
@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo,String> {

}
