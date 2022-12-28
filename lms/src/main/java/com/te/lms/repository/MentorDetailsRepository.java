package com.te.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.batchentity.MentorDetails;

@Repository
public interface MentorDetailsRepository extends JpaRepository<MentorDetails, Integer> {

}
