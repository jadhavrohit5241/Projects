package com.te.securityjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.securityjwt.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {

	Optional<AppUser> findByUsername(String username);
}
