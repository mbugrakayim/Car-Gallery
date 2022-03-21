package com.backend.cargallery.service.impl;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.backend.cargallery.dao.CarImagesRepository;
import com.backend.cargallery.dao.CarRepository;
import com.backend.cargallery.exception.NotFoundException;
import com.backend.cargallery.model.Car;
import com.backend.cargallery.model.CarImages;
import com.backend.cargallery.service.CarImageService;



@Service
public class CarImagesServiceImpl implements CarImageService {
	@Autowired
	private CarImagesRepository carImagesRepository;
	@Autowired
	CarRepository carRepository;
	
	@Override
	public CarImages createCarImage(Car carId, MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		CarImages carImages = new CarImages();
		carImages.setName(fileName);
		carImages.setType(file.getContentType());
		carImages.setImages(file.getBytes());
		carImages.setCarId(carId);
		return carImagesRepository.save(carImages);
	}
	
	@Override
	public List<CarImages> findAllCarImages() {
		return carImagesRepository.findAll();
	}
	
	@Override
	public CarImages findByIdCarImage(Long id) {
		return carImagesRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Image Not Found with id: " + id));
	}
	
	@Override
	public CarImages updateCarImages(Long id, MultipartFile file) throws IOException {
		CarImages images = carImagesRepository.findById(id).orElseThrow(() -> new NotFoundException("Image Not Found with id: " + id));
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		images.setImages(file.getBytes());
		images.setType(file.getContentType());
		images.setName(fileName);
		return carImagesRepository.save(images);
	}
	@Override
	public void deleteCarImage(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
