package com.backend.cargallery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.cargallery.model.Rental;
@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

}
