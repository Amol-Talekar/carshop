package com.springbootproject.carshop.service;

import com.springbootproject.carshop.entity.Car;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

//@ComponentScan(basePackages = "com.springbootproject.carshop")
public interface CarService {

    public List<Car> findAll();
    public Car findById(int theId);
    public void save(Car theCar);
    public void  deleteById(int theId);

    List<Car> findCarByCategory(int idcategory);
}
