package com.backend.cargallery.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.backend.cargallery.model.CarImages;
@Repository
public interface CarImagesRepository extends JpaRepository<CarImages, String> {


	
}
