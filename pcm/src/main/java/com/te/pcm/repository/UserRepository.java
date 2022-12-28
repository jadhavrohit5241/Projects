package com.te.pcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findByEmployeeName(String username);
	//to find user by username 
}
