package com.springbootproject.carshop;

import com.springbootproject.carshop.controller.CategoryController;
import com.springbootproject.carshop.controller.LoginController;
import com.springbootproject.carshop.dao.CarRepository;
import com.springbootproject.carshop.dao.CategoryRepository;
import com.springbootproject.carshop.entity.Car;
import com.springbootproject.carshop.entity.Category;
import com.springbootproject.carshop.service.CarService;
import com.springbootproject.carshop.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@SpringBootTest
class CarshopApplicationTests {

	@Test
	void contextLoads() {
	}

	@MockBean
	private CarRepository carRepository;

	@Autowired
	private CarService carService;

	@Autowired
	private CategoryService categoryService;

	@MockBean
	private CategoryRepository categoryRepository;

	@Mock
	private Model theModel;

									// Testing Services
	@Test
	void findAllCarsTest(){
		when(carRepository.findAll()).thenReturn(
				Stream.of(
						new Car(89,"TestCar1",56,57,new Category("SUV")),
						new Car(90,"TestCar2",76,57,new Category("Sedan"))
				).collect(Collectors.toList()));
		Assertions.assertEquals(2,carRepository.findAll().size());
	}

	@Test
	void saveCarTest(){
		Car car= new Car(1,"TestCarSave",11,12,new Category("SUV"));
		carRepository.save(car);
		verify(carRepository,times(1)).save(car);
	}

	@Test
	void  deleteCarTest(){
		int id=1;
		carRepository.deleteById(id);
		verify(carRepository,times(1)).deleteById(id);
	}

	@Test
	void findAllCategoriesTest() {
		when(categoryRepository.findAll()).thenReturn(
				Stream.of(
								new Category("Test Category 1"),
								new Category("Test Category 2")
						)
						.collect(Collectors.toList()));

		Assertions.assertEquals(2, categoryRepository.findAll().size());

	}

	@Test
	void findByIdCategoryTest() {
		int id = 1;
		when(categoryRepository.findById(id)).thenReturn(
				Optional.of(new Category("Test Category 1"))
		);

		Assertions.assertEquals("Test Category 1", categoryService.findById(id).getName());
	}

	@Test
	void saveCategoryTest() {
		Category category = new Category("Test Category 1");
		categoryRepository.save(category);
		verify(categoryRepository, times(1)).save(category);
	}

	@Test
	void deleteCategoryTest() {
		int id = 1;
		categoryRepository.deleteById(id);
		verify(categoryRepository, times(1)).deleteById(id);
	}

									//Testing Controllers
	@Test
	void listAllCarsControllerTest(){
		when(carRepository.findAll()).thenReturn(
				Stream.of(
						new Car(89,"TestCar1",56,57,new Category("SUV")),
						new Car(90,"TestCar2",76,57,new Category("Sedan"))

				).collect(Collectors.toList()));

		Assertions.assertEquals(2, carService.findAll().size());
	}

	@Test
	void saveCarControllerTest(){
		Car car= new Car(1,"TestCarSave",11,12,new Category("SUV"));
		carService.save(car);
		verify(carRepository,times(1)).save(car);
	}

	@Test
	void  deleteCarControllerTest(){
		int id=1;
		carService.deleteById(id);
		verify(carRepository,times(1)).deleteById(id);
	}

	@Test
	void findAllCategoriesControllerTest() {
		when(categoryRepository.findAll()).thenReturn(
				Stream.of(
								new Category("Test Category 1"),
								new Category("Test Category 2")
						)
						.collect(Collectors.toList()));

		Assertions.assertEquals(2, categoryRepository.findAll().size());

	}

	@Test
	void saveCategoryControllerTest() {
		Category category = new Category("Test");
		categoryService.save(category);
		verify(categoryRepository, times(1)).save(category);
	}

	@Test
	void deleteCategoryControllerTest() {
		int id = 1;
		categoryService.deleteById(id);
		verify(categoryRepository, times(1)).deleteById(id);
	}

	@Test
	void loginControllerTest(){
		LoginController loginController=new LoginController();
		String response= loginController.showMyLoginPage();
		Assertions.assertEquals("loginpage",response);
	}

}
