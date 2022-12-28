package com.te.pcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.entity.Options;
@Repository
public interface OptionsRepository extends JpaRepository<Options, Integer> {

}
