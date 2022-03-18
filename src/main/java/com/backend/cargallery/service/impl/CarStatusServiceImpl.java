package com.backend.cargallery.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.cargallery.dao.CarStatusRepository;
import com.backend.cargallery.exception.NotFoundException;
import com.backend.cargallery.model.CarStatus;
import com.backend.cargallery.service.CarStatusService;
@Service
public class CarStatusServiceImpl implements CarStatusService{
	CarStatusRepository carStatusRepository;


	public CarStatusServiceImpl(CarStatusRepository carStatusRepository) {
		super();
		this.carStatusRepository = carStatusRepository;
	}


	@Override
	public CarStatus saveStatus(CarStatus carStatus) {		
		return carStatusRepository.save(carStatus);
	}


	@Override
	public List<CarStatus> findAllStatus() {
		return carStatusRepository.findAll();
	}


	@Override
	public CarStatus findByIdStatus(Long id) {
		return carStatusRepository.findById(id).orElseThrow(() -> new NotFoundException("Status Not Found with id: " +id));
	}


	@Override
	public CarStatus updateStatu(CarStatus carStatus, Long id) {
		CarStatus status = carStatusRepository.findById(id).orElseThrow(() -> new NotFoundException("Status Not Found with id: " +id));
		status.setCarId(carStatus.getCarId());
		status.setEndDate(carStatus.getEndDate());
		status.setStartDate(carStatus.getStartDate());
		status.setStatus(carStatus.getStatus());
		carStatusRepository.save(status);
		return status;
	}


	@Override
	public void deleteStatu(Long id) {
		carStatusRepository.findById(id).orElseThrow(() -> new NotFoundException("Status Not Found with id: " +id));
		carStatusRepository.deleteById(id);
		
	}
	
	
}
