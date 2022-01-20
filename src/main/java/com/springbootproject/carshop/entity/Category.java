package com.springbootproject.carshop.entity;




import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;



@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="idcategory")
    private int idcategory;

    @NotBlank(message = "Category Name can't be blank")
    @Column(name = "category_name")
    @Size(min=2, max=30, message = "category name should have at-least 2 characters")
    private String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Car> cars;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
