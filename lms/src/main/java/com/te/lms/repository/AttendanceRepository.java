package com.te.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.emploeeentity.Attendance;
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Integer>{

}
