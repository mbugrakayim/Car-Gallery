package com.backend.cargallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.cargallery.model.Payment;
import com.backend.cargallery.service.PaymentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
	
	private PaymentService paymentService;

	@Autowired
	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment){
		return new ResponseEntity<Payment>(paymentService.createPayment(payment) , HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Payment> findAllPayments(){
		return paymentService.findAllPayment();
	}


	@GetMapping("{id}")
	public ResponseEntity<Payment> findByIdPayment(@PathVariable("id") Long id){
		return new ResponseEntity<Payment>(paymentService.findByIdPayment(id),HttpStatus.OK);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable("id") Long id , @RequestBody Payment payment){
		return new ResponseEntity<Payment>(paymentService.updatePayment(payment, id) , HttpStatus.OK);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePayment(@PathVariable("id") Long id){
		paymentService.deletePayment(id);
		return new ResponseEntity<String>("Payment deleted successfully!.",HttpStatus.OK);
	}
	

}
