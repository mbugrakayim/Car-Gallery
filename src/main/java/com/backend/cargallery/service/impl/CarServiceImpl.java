package com.backend.cargallery.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.cargallery.dao.CarRepository;
import com.backend.cargallery.exception.NotFoundException;
import com.backend.cargallery.model.Car;

import com.backend.cargallery.service.CarServices;

@Service
public class CarServiceImpl implements CarServices {
	
	CarRepository carRepository;

	
	public CarServiceImpl(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}


	@Override
	public Car createCar(Car car) {
		return carRepository.save(car);
		
	}


	@Override
	public List<Car> findAllCar() {
		return carRepository.findAll();
	}


	@Override
	public Car findByIdCar(Long id) {
		return carRepository.findById(id).orElseThrow(()-> new NotFoundException("Car Not Found with id:" +id));
	}


	@Override
	public Car updateCar(Car car, Long id) {
		Car car1 = carRepository.findById(id).orElseThrow(()-> new NotFoundException("Car Not Found with id:" +id));
		car1.setBodyType(car.getBodyType());
		car1.setBrand(car.getBrand());
		car1.setFuelType(car.getFuelType());
		car1.setDescription(car.getDescription());
		car1.setPrice(car.getPrice());
		car1.setGearBox(car.getGearBox());
		car1.setModel(car.getModel());
		car1.setPlaka(car1.getPlaka());
		car1.setPrice(car.getPrice());
		carRepository.save(car1);
		return car1;
	}


	@Override
	public void deleteCar(Long id) {
		carRepository.findById(id).orElseThrow(()-> new NotFoundException("Car Not Found with id:" +id));
		carRepository.deleteById(id);
		
	}
	

}
