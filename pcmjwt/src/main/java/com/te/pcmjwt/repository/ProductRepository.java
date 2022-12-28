package com.te.pcmjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcmjwt.entity.Products;
@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

}
