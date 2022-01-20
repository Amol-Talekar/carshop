package com.springbootproject.carshop.dto;

import com.springbootproject.carshop.entity.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CarDTO {
    private int idcar;

    @NotEmpty(message = "Car Model Name can not be Empty")
    private String model;


    @Min(value = 1,message = "Mileage can't be less than 1 km/lt")
    private int mileage;

    @Min(value = 1,message = "Price can't be less than 1 lakh")
    private int price;

    @NotNull(message = "Please Choose a Category")
    private Category category;

    public CarDTO() {
    }

    public CarDTO(int idcar, String model, int mileage, int price, Category category) {
        this.idcar = idcar;
        this.model = model;
        this.mileage = mileage;
        this.price = price;
        this.category = category;
    }

    public int getIdcar() {
        return idcar;
    }

    public void setIdcar(int idcar) {
        this.idcar = idcar;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
