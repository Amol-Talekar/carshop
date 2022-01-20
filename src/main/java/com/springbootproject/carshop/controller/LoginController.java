package com.springbootproject.carshop.controller;

import com.springbootproject.carshop.entity.Car;
import com.springbootproject.carshop.entity.Category;
import com.springbootproject.carshop.service.CarService;
import com.springbootproject.carshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
//@ComponentScan(basePackages = "com.springbootproject.carshop")
@RequestMapping("/")
public class LoginController {


    @Autowired
    private CarService carService;


    @Autowired
    private CategoryService categoryService;
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "loginpage";

    }

    @GetMapping("/")
    public String index(@RequestParam("idcategory") Optional<Integer> idcategory, Model theModel){

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
        return "index";
    }

    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";

    }
}
