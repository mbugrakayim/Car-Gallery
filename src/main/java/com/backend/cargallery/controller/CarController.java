package com.backend.cargallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.cargallery.model.Car;
import com.backend.cargallery.service.CarServices;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/car")
public class CarController {
	
	private CarServices carServices;

	@Autowired
	public CarController(CarServices carServices) {
		super();
		this.carServices = carServices;
	}
	@PostMapping()
	public ResponseEntity<Car> saveCar(@RequestBody Car car){
		return new ResponseEntity<Car>(carServices.createCar(car) , HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Car> findAllCar(){
		return carServices.findAllCar();
	}


	@GetMapping("{id}")
	public ResponseEntity<Car> findByIdCar(@PathVariable("id") Long id){
		return new ResponseEntity<Car>(carServices.findByIdCar(id),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Car> updateCar(@PathVariable("id") Long id , @RequestBody Car car){
		return new ResponseEntity<Car>(carServices.updateCar(car, id) , HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCar(@PathVariable("id") Long id){
		carServices.deleteCar(id);
		return new ResponseEntity<String>("Car deleted successfully!.",HttpStatus.OK);
	}

}
