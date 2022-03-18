package com.backend.cargallery.service;

import java.util.List;

import com.backend.cargallery.model.Car;


public interface CarServices {
	Car saveCar(Car car);
	List<Car> findAllCar();
	Car findByIdCar(Long id);
	Car updateCar(Car car , Long id);
	void deleteCar(Long id);
}
