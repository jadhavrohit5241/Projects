package com.te.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.batchentity.BatchDetails;

@Repository
public interface BatchRepository extends JpaRepository<BatchDetails,Integer> {

}
