package com.te.securityjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.securityjwt.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

	Optional<Roles> findByRoleName(String roleName);
}
