package com.backend.cargallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.cargallery.model.Car;
import com.backend.cargallery.model.CarImages;
import com.backend.cargallery.payload.MessageResponse;
import com.backend.cargallery.service.impl.CarImagesServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/images")
public class CarImagesController {

	@Autowired
	private CarImagesServiceImpl carImagesServiceImpl;

	@PostMapping("/upload")
	public ResponseEntity<MessageResponse> createCarImage(@ModelAttribute("carId") Car carId ,@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			carImagesServiceImpl.createCarImage(carId , file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}
	}
	
	@GetMapping("/files")
	public ResponseEntity<List<CarImages>> findAllCarImage(){
		return new ResponseEntity<List<CarImages>>(carImagesServiceImpl.findAllCarImages() , HttpStatus.OK);
	}
	
	@GetMapping("/files/{id}")
	public ResponseEntity<CarImages> findByIdCarImage(@PathVariable Long id){
		return new ResponseEntity<CarImages>(carImagesServiceImpl.findByIdCarImage(id) , HttpStatus.OK);
	}
	
	@PutMapping("/files/{id}")
	public ResponseEntity<MessageResponse> updateCarImage(@PathVariable("id") Long id ,@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			carImagesServiceImpl.updateCarImages(id, file);
			message = "Successfully updated.: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			e.printStackTrace();
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}
	}
	
	@DeleteMapping("/files/{id}")
	public ResponseEntity<MessageResponse> deleteCarImage(@PathVariable("id") Long id){
		carImagesServiceImpl.deleteCarImage(id);
		String message = "Succesfully..";
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
	}
	
	
}
