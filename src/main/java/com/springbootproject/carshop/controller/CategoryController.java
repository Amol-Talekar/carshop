package com.springbootproject.carshop.controller;

import com.springbootproject.carshop.dto.CategoryDTO;
import com.springbootproject.carshop.entity.Category;
import com.springbootproject.carshop.service.CarService;
import com.springbootproject.carshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CarService carService;


    public CategoryController(CategoryService theCategoryService){
        categoryService=theCategoryService;
    }

    @GetMapping("/categories")
    public String listCategories(Model theModel){
        List<Category> theCategories= categoryService.findAll();

        System.out.println("this is from CategoryController "+ theCategories);
        //add to the spring model
        theModel.addAttribute("categories",theCategories);

        return "list-categories";
    }

    @GetMapping("/categories/addCategory")
    public String addCategory(Model theModel){
        CategoryDTO categoryDTO = new CategoryDTO();
        theModel.addAttribute("category",categoryDTO);
        return "category-form-page";
    }

    @PostMapping("/categories/save")
    public String saveCategory(@Valid @ModelAttribute("category") CategoryDTO categoryDTO, BindingResult bindingResult,
                               Model theModel){

        System.out.println("\n Amol Talekar before if this is from categorycontroller "+ bindingResult);
        if(bindingResult.hasErrors()) {
            System.out.println("Amol Talekar this is from categorycontroller "+ bindingResult);
            return "category-form-page";
        }
        else {
            List<Category> categories = categoryService.findAll();
            for(Category tempCategory : categories){
                if(tempCategory.getName().equalsIgnoreCase(categoryDTO.getName())){
                    return "category-already-exist";
                }
            }
            Category category = new Category(categoryDTO.getName());
            category.setIdcategory(categoryDTO.getIdcategory());

            categoryService.save(category);
            return "redirect:/shop/categories";

        }


    }

    @GetMapping("/categories/updateCategory")
    public String updateCategory(@RequestParam("idcategory") int idcategory,Model theModel){
        Category category=categoryService.findById(idcategory);
        theModel.addAttribute("category",category);

        return "category-form-page";
    }

    @GetMapping("/categories/deleteCategory")
    public String deleteCategory(@RequestParam("idcategory") int idcategory){
        categoryService.deleteById(idcategory);

        return "redirect:/shop/categories";
    }
}
