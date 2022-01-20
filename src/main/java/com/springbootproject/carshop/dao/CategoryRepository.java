package com.springbootproject.carshop.dao;

import com.springbootproject.carshop.entity.Category;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
