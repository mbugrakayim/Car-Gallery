package com.backend.cargallery.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.cargallery.dao.BookingRepository;
import com.backend.cargallery.exception.NotFoundException;
import com.backend.cargallery.model.Booking;
import com.backend.cargallery.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	BookingRepository bookingRepository;

	
	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}


	@Override
	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}


	@Override
	public List<Booking> findAllBookings() {
		return bookingRepository.findAll();
	}


	@Override
	public Booking findByIdBooking(Long id) {
		return bookingRepository.findById(id).orElseThrow(() -> new NotFoundException("Booking Not Found with id :" +id));
	}


	@Override
	public Booking updateBooking(Booking booking, Long id) {
		Booking book = bookingRepository.findById(id).orElseThrow(() -> new NotFoundException("Booking Not Found with id :" +id));
		book.setCustomerId(booking.getCustomerId());
		book.setCarId(booking.getCarId());
		book.setDescription(booking.getDescription());
		book.setEmployeeId(booking.getEmployeeId());
		book.setPrice(booking.getPrice());
		book.setRentDate(booking.getRentDate());
		book.setReturnDate(booking.getReturnDate());
		bookingRepository.save(book);
		return book;
	}


	@Override
	public void deleteBooking(Long id) {
		 bookingRepository.findById(id).orElseThrow(() -> new NotFoundException("Booking Not Found with id :" +id));
		 bookingRepository.deleteById(id);
		
	}
	
	
}
