package com.backend.cargallery.service;

import java.util.List;

import com.backend.cargallery.model.Rental;


public interface RentalService {
	Rental createRental(Rental rental);
	List<Rental> findAllRental();
	Rental findByIdRental(Long id);
	Rental updateRental(Rental rental , Long id);
	void deleteRental(Long id);
}
