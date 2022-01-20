package com.springbootproject.carshop.custom.exceptions;

public class CategoryNotFoundException extends RuntimeException{

    public  CategoryNotFoundException(String message) {
        super(message);
    }
}