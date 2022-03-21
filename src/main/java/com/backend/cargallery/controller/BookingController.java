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

import com.backend.cargallery.model.Booking;

import com.backend.cargallery.service.BookingService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
	
	private BookingService bookingService;

	@Autowired
	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking){
		return new ResponseEntity<Booking>(bookingService.createBooking(booking) , HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Booking> findAllBookings(){
		return bookingService.findAllBookings();
	}


	@GetMapping("{id}")
	public ResponseEntity<Booking> findByIdBooking(@PathVariable("id") Long id){
		return new ResponseEntity<Booking>(bookingService.findByIdBooking(id),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable("id") Long id , @RequestBody Booking booking){
		return new ResponseEntity<Booking>(bookingService.updateBooking(booking, id) , HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable("id") Long id){
		bookingService.deleteBooking(id);
		return new ResponseEntity<String>("Booking deleted successfully!.",HttpStatus.OK);
	}
	

}
