package com.springbootproject.carshop.service;

import com.springbootproject.carshop.custom.exceptions.CarNotFoundException;
import com.springbootproject.carshop.dao.CarRepository;
import com.springbootproject.carshop.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@ComponentScan(basePackages = "com.springbootproject.carshop")
public class CarServiceImpl implements CarService{


    @Autowired
    private CarRepository carRepository;


    public CarServiceImpl( CarRepository theCarRepository){
        carRepository= theCarRepository;
    }

    @Override
    public List<Car> findAll() {

        return carRepository.findAll();
    }

    @Override
    public Car findById(int theId) {

        Optional<Car> result = carRepository.findById(theId);

        Car car;

        if(result.isPresent()){
            car=result.get();
        }
        else {
            throw new CarNotFoundException("This car doesn't exist");
        }

        return car;
    }

    @Override
    public void save(Car theCar) {
            carRepository.save(theCar);
    }

    @Override
    public void deleteById(int theId) {
            carRepository.deleteById(theId);
    }

    @Override
    public List<Car> findCarByCategory(int idcategory) {

       List<Car> carsByCategory=new ArrayList<>();
       List<Car> cars= carRepository.findAll();
       for (Car car: cars){
           if(car.getCategory().getIdcategory()==idcategory){
               carsByCategory.add(car);
           }
       }
        return carsByCategory;
    }


}
