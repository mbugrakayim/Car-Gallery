package com.backend.cargallery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.cargallery.model.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
