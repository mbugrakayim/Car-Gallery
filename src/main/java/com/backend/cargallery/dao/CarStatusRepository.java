package com.backend.cargallery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.cargallery.model.CarStatus;
@Repository
public interface CarStatusRepository extends JpaRepository<CarStatus, Long> {

}
