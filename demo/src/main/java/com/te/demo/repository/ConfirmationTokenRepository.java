package com.te.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.demo.entity.ConfirmationToken;
@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken,Long> {

	Optional<ConfirmationToken> findByConfirmationToken(String token);
}
