package com.springbootproject.carshop.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CategoryDTO {

    private int idcategory;

    @NotEmpty(message = "Category Name can not be Empty")
    private String name;

    public CategoryDTO(int idcategory, String name) {
        this.idcategory = idcategory;
        this.name = name;
    }

    public CategoryDTO() {
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
