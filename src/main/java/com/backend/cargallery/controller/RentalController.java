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


import com.backend.cargallery.model.Rental;
import com.backend.cargallery.service.RentalService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/rental")
public class RentalController {
	
	private RentalService rentalService;

	@Autowired
	public RentalController(RentalService rentalService) {
		super();
		this.rentalService = rentalService;
	}
	@PostMapping("/create")
	public ResponseEntity<Rental> createRental(@RequestBody Rental rental){
		return new ResponseEntity<Rental>(rentalService.createRental(rental) , HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Rental> findAllRentals(){
		return rentalService.findAllRental();
	}


	@GetMapping("{id}")
	public ResponseEntity<Rental> findByIdRental(@PathVariable("id") Long id){
		return new ResponseEntity<Rental>(rentalService.findByIdRental(id),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Rental> updateRental(@PathVariable("id") Long id , @RequestBody Rental rental){
		return new ResponseEntity<Rental>(rentalService.updateRental(rental, id) , HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteRental(@PathVariable("id") Long id){
		rentalService.deleteRental(id);
		return new ResponseEntity<String>("Rental deleted successfully!.",HttpStatus.OK);
	}
	

}
