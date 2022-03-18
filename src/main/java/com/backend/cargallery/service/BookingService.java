package com.backend.cargallery.service;

import java.util.List;

import com.backend.cargallery.model.Booking;

public interface BookingService {
	Booking saveBooking(Booking booking);

	List<Booking> findAllBookings();

	Booking findByIdBooking(Long id);

	Booking updateBooking(Booking booking, Long id);

	void deleteBooking(Long id);
}
