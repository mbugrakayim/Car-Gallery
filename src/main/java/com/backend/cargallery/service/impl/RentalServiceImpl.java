package com.backend.cargallery.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.cargallery.dao.RentalRepository;
import com.backend.cargallery.exception.NotFoundException;
import com.backend.cargallery.model.Rental;
import com.backend.cargallery.service.RentalService;

@Service
public class RentalServiceImpl implements RentalService {

	RentalRepository rentalRepository;

	
	public RentalServiceImpl(RentalRepository rentalRepository) {
		super();
		this.rentalRepository = rentalRepository;
	}


	@Override
	public Rental saveRental(Rental rental) {
		return rentalRepository.save(rental);
	}


	@Override
	public List<Rental> findAllRental() {
		return rentalRepository.findAll();
	}


	@Override
	public Rental findByIdRental(Long id) {
		return rentalRepository.findById(id).orElseThrow(() -> new NotFoundException("Rental Not Found with id:" +id));
	}


	@Override
	public Rental updateRental(Rental rental, Long id) {
		Rental ren = rentalRepository.findById(id).orElseThrow(() -> new NotFoundException("Rental Not Found with id:" +id));
		ren.setCarId(rental.getCarId());
		ren.setCustomerId(rental.getCustomerId());
		ren.setDescription(rental.getDescription());
		ren.setEmployeeId(rental.getEmployeeId());
		ren.setPrice(rental.getPrice());
		ren.setRentDate(rental.getRentDate());
		ren.setReturnDate(rental.getReturnDate());
		rentalRepository.save(ren);
		return ren;
	}


	@Override
	public void deleteRental(Long id) {
		rentalRepository.findById(id).orElseThrow(() -> new NotFoundException("Rental Not Found with id:" +id));
		rentalRepository.deleteById(id);
		
	}
	
	
}
