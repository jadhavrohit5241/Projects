package com.te.pcmjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcmjwt.entity.OptionTypes;
@Repository
public interface OptionsTypeRepository extends JpaRepository<OptionTypes, Integer> {

}
