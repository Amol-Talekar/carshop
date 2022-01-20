package com.springbootproject.carshop.service;

import com.springbootproject.carshop.custom.exceptions.CategoryNotFoundException;
import com.springbootproject.carshop.dao.CategoryRepository;
import com.springbootproject.carshop.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository theCategoryServiceImpl){
        categoryRepository=theCategoryServiceImpl;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int idcategory) {
       Optional<Category> result = categoryRepository.findById(idcategory);

       Category category;
       if(result.isPresent()){
           category=result.get();
       }
       else {
           throw new CategoryNotFoundException(("Could not find the Category"));

       }

        return category;
    }

    @Override
    public void save(Category theCategory) {
            categoryRepository.save(theCategory);
    }

    @Override
    public void deleteById(int idcategory) {
            categoryRepository.deleteById(idcategory);
    }
}
