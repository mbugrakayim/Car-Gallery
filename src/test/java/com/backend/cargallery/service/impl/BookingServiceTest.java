package com.backend.cargallery.service.impl;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.backend.cargallery.model.Booking;
import com.backend.cargallery.service.BookingService;

@SpringBootTest
public class BookingServiceTest {
	
	@Autowired
	private BookingService bookingService;
	
	@Test
	public void testFindAllBookings(){
		List<Booking> list = bookingService.findAllBookings();
		System.out.println();
	}

}
