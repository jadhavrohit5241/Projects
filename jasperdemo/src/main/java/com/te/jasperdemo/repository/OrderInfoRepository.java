package com.te.jasperdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.jasperdemo.entity.OrderInfo;
@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo,String> {

}
