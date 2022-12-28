package com.te.pcmjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcmjwt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findByEmployeeName(String username);
	//to find user by username 
}
