package com.te.pcmjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcmjwt.entity.AppUser;
import com.te.pcmjwt.entity.VariationsTypes;


@Repository
public interface VariationTypeRepository extends JpaRepository<VariationsTypes, Integer>{

}
