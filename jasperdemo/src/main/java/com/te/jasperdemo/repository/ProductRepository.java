package com.te.jasperdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.jasperdemo.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

}
