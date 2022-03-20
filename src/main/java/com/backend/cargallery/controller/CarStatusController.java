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

import com.backend.cargallery.model.CarStatus;
import com.backend.cargallery.service.CarStatusService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/status")
public class CarStatusController {

	private CarStatusService carStatusService;

	@Autowired
	public CarStatusController(CarStatusService carStatusService) {
		super();
		this.carStatusService = carStatusService;
	}
	@PostMapping("/create")
	public ResponseEntity<CarStatus> saveStatus(@RequestBody CarStatus status){
		return new ResponseEntity<CarStatus>(carStatusService.createStatus(status) , HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<CarStatus> findAllStatus(){
		return carStatusService.findAllStatus();
	}


	@GetMapping("{id}")
	public ResponseEntity<CarStatus> findByIdStatus(@PathVariable("id") Long id){
		return new ResponseEntity<CarStatus>(carStatusService.findByIdStatus(id),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<CarStatus> updateStatus(@PathVariable("id") Long id , @RequestBody CarStatus status){
		return new ResponseEntity<CarStatus>(carStatusService.updateStatu(status, id) , HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStatus(@PathVariable("id") Long id){
		carStatusService.deleteStatu(id);
		return new ResponseEntity<String>("Car Status deleted successfully!.",HttpStatus.OK);
	}
	
	
}
