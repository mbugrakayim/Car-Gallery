package com.backend.cargallery.service;

import java.util.List;

import com.backend.cargallery.model.CarStatus;


public interface CarStatusService {
	CarStatus saveStatus(CarStatus carStatus);
	List<CarStatus> findAllStatus();
	CarStatus findByIdStatus(Long id);
	CarStatus updateStatu(CarStatus carStatus , Long id);
	void deleteStatu(Long id);
}
