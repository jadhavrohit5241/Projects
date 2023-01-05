package com.te.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.demo.entity.OtpEntity;
@Repository
public interface OtpRepository extends JpaRepository<OtpEntity, String>{

	Optional<OtpEntity>findByUserName(String userName);
}
