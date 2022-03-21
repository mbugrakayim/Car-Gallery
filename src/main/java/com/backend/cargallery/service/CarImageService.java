package com.backend.cargallery.service;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import com.backend.cargallery.model.Car;
import com.backend.cargallery.model.CarImages;

public interface CarImageService {
	CarImages createCarImage(Car carId , MultipartFile file) throws IOException;
	List<CarImages> findAllCarImages();
	CarImages findByIdCarImage(Long id);
	CarImages updateCarImages(Long id , MultipartFile file)throws IOException;
	void deleteCarImage(Long id);
}
