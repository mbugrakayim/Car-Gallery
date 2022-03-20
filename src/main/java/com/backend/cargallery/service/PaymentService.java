package com.backend.cargallery.service;

import java.util.List;

import com.backend.cargallery.model.Payment;


public interface PaymentService {
	Payment createPayment(Payment payment);
	List<Payment> findAllPayment();
	Payment findByIdPayment(Long id);
	Payment updatePayment(Payment payment , Long id);
	void deletePayment(Long id);
}
