package com.te.pcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.entity.Products;
@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

}
