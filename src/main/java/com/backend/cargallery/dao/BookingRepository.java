package com.backend.cargallery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.cargallery.model.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
