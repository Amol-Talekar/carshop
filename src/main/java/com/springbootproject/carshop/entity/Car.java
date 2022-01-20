package com.springbootproject.carshop.entity;



import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "car", schema = "carshop")
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idcar")
    private int idcar;

    @NotEmpty(message = "Car Model can not be Empty")
   @Column(name = "model")
    private String model;



    @Column(name = "mileage")
    private int mileage;



    @Column(name = "price")
    private int price;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "category_idcategory")
    private Category category;

    public Car() {
    }

    public Car(int idcar, String model, int mileage, int price, Category category) {
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
