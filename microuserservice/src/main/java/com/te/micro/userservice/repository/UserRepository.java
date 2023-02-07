package com.te.micro.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.micro.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
