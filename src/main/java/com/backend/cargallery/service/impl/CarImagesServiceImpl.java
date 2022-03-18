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
import com.backend.cargallery.model.CarImages;



@Service
public class CarImagesServiceImpl{
	@Autowired
	CarImagesRepository carImagesRepository;
	@Autowired
	CarRepository carRepository;
	
	public CarImages store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    CarImages carImages = new CarImages(fileName, file.getContentType(), file.getBytes());
	    return carImagesRepository.save(carImages);
	  }
	public CarImages update(String id, MultipartFile file) throws IOException {
		CarImages images = carImagesRepository.findById(id).orElseThrow(()-> new NotFoundException("Customer not found with id: " +id));
		images.setName(StringUtils.cleanPath(file.getOriginalFilename()));
		images.setType(file.getContentType());
		images.setImages(file.getBytes());
		return carImagesRepository.save(images);
	}
	  public CarImages getFile(String id) {
	    return carImagesRepository.findById(id).get();
	  }
	  public Stream<CarImages> getAllFiles() {
	    return carImagesRepository.findAll().stream();
	  }
	
}
