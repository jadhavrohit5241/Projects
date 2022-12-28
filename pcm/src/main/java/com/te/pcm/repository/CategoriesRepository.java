package com.te.pcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.entity.Categories;
@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}
