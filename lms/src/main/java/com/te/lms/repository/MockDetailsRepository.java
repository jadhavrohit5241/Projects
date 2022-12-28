package com.te.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.batchentity.MockDetails;
@Repository
public interface MockDetailsRepository extends JpaRepository<MockDetails, Integer> {
	@Query("SELECT COUNT(*) FROM MockDetails  GROUP BY OverallFeedback")
	List<Long> countEmployeeOverallfeedback();
	
	
	
	
}
