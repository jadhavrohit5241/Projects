package com.te.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.batchentity.MockInfo;
@Repository
public interface MockRepository extends JpaRepository<MockInfo, Integer> {

}
