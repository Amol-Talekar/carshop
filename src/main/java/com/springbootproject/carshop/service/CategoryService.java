package com.springbootproject.carshop.service;


import com.springbootproject.carshop.entity.Category;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

//@ComponentScan(basePackages = "com.springbootproject.carshop")
public interface CategoryService {
    public List<Category> findAll();
    public Category findById(int theId);
    public void save(Category theCar);
    public void  deleteById(int idcategory);
}
