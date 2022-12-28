package com.te.pcmjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcmjwt.entity.Options;
@Repository
public interface OptionsRepository extends JpaRepository<Options, Integer> {

}
