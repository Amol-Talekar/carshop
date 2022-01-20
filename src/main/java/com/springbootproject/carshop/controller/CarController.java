package com.springbootproject.carshop.controller;

import com.springbootproject.carshop.dto.CarDTO;
import com.springbootproject.carshop.entity.Car;
import com.springbootproject.carshop.entity.Category;
import com.springbootproject.carshop.service.CarService;
import com.springbootproject.carshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/shop")
public class CarController {



    @Autowired
    private CarService carService;


    @Autowired
    private CategoryService categoryService;


    public CarController(CarService theCarService) {
        carService= theCarService;

    }


    @GetMapping("/cars")
    public String listCars(@RequestParam("idcategory") Optional<Integer> idcategory, Model theModel){

        List<Car> theCars;
        if(idcategory.isEmpty()){
            theCars=carService.findAll();
        }
        else {
            theCars=carService.findCarByCategory(idcategory.get().intValue());
        }
        theModel.addAttribute("cars",theCars);
        List<Category> categories= categoryService.findAll();
        theModel.addAttribute("categories",categories);

        return "list-cars";
    }

    @GetMapping("/cars/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        CarDTO carDTO=new CarDTO();
        theModel.addAttribute("car",carDTO);

        List<Category> categories= categoryService.findAll();
        theModel.addAttribute("categories",categories);

        return "car-form-page";
    }

    @GetMapping("/cars/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("idcar") int idcar,
                                    Model theModel) {

        Car car = carService.findById(idcar);
        theModel.addAttribute("car",car);

        List<Category> categories=categoryService.findAll();
        theModel.addAttribute("categories",categories);

        // send over to our form
        return "car-form-page";
    }


    @PostMapping("/cars/saveCar")
    public String saveCar(@Valid @ModelAttribute("car") CarDTO carDTO, BindingResult bindingResult, Model theModel) {

       if(bindingResult.hasErrors()){
           theModel.addAttribute("car",carDTO);
           List<Category> categories=categoryService.findAll();
           theModel.addAttribute("categories",categories);
           return "car-form-page";
       }

       Car car= new Car(carDTO.getIdcar(),carDTO.getModel(),carDTO.getMileage(),carDTO.getPrice(),carDTO.getCategory());

       car.setIdcar(carDTO.getIdcar());

       carService.save(car);

        // use a redirect to prevent duplicate submissions
        return "redirect:/shop/cars";
    }


    @GetMapping("/cars/deleteCar")
    public String deleteCar(@RequestParam("idcar") int theId) {

        System.out.println("this id from car controller" + theId);
        // delete the Car
        carService.deleteById(theId);


        return "redirect:/shop/cars";

    }

}
