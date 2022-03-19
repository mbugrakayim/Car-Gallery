package com.backend.cargallery.service.impl;

import java.io.IOException;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.backend.cargallery.dao.CarImagesRepository;
import com.backend.cargallery.dao.CarRepository;
import com.backend.cargallery.exception.NotFoundException;
import com.backend.cargallery.model.Car;
import com.backend.cargallery.model.CarImages;



@Service
public class CarImagesServiceImpl{
	@Autowired
	private CarImagesRepository carImagesRepository;
	@Autowired
	CarRepository carRepository;
	
	public CarImages store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    CarImages carImages = new CarImages(fileName, file.getContentType(), file.getBytes());
	    return carImagesRepository.save(carImages);
	  }
	public CarImages update(String imageId , Long carId) throws IOException {
		CarImages images = carImagesRepository.findById(imageId).orElseThrow(()-> new NotFoundException("Car images not found with id: " +imageId));
		Car car = carRepository.findById(carId).orElseThrow(()-> new NotFoundException("Car not found with id: " +carId));
		images.setCarId(car);
		return carImagesRepository.save(images);
	}
	  public CarImages getFile(String id) {
	    return carImagesRepository.findById(id).get();
	  }
	  public Stream<CarImages> getAllFiles() {
	    return carImagesRepository.findAll().stream();
	  }
}
