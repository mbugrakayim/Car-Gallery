package com.backend.cargallery.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.cargallery.dao.PaymentRepository;
import com.backend.cargallery.exception.NotFoundException;
import com.backend.cargallery.model.Payment;
import com.backend.cargallery.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	PaymentRepository paymentRepository;

	
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		super();
		this.paymentRepository = paymentRepository;
	}


	@Override
	public Payment savePayment(Payment payment) {
		
		return paymentRepository.save(payment);
	}


	@Override
	public List<Payment> findAllPayment() {
		return paymentRepository.findAll();
	}


	@Override
	public Payment findByIdPayment(Long id) {
		
		return paymentRepository.findById(id).orElseThrow(() -> new NotFoundException("Payment Not Found With id:" + id));
	}


	@Override
	public Payment updatePayment(Payment payment, Long id) {
		Payment pay = paymentRepository.findById(id).orElseThrow(() -> new NotFoundException("Payment Not Found With id:" + id));
		pay.setAmount(payment.getAmount());
		pay.setDescription(payment.getDescription());
		pay.setCustomerId(payment.getCustomerId());
		pay.setEmployeeId(payment.getEmployeeId());
		pay.setPaymentDate(payment.getPaymentDate());
		pay.setRentalId(payment.getRentalId());
		paymentRepository.save(pay);
		return pay;
	}


	@Override
	public void deletePayment(Long id) {
		paymentRepository.findById(id).orElseThrow(() -> new NotFoundException("Payment Not Found With id:" + id));
		paymentRepository.deleteById(id);
		
	}
	
	

}
