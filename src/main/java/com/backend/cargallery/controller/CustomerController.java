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



import com.backend.cargallery.model.Customer;
import com.backend.cargallery.service.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	
	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.createCustomer(customer) , HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Customer> findAllCustomer(){
		return customerService.findAllCustomers();
	}


	@GetMapping("{id}")
	public ResponseEntity<Customer> findByIdCustomer(@PathVariable("id") Long id){
		return new ResponseEntity<Customer>(customerService.findByIdCustomer(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id , @RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id) , HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id){
		customerService.deleteCustomer(id);
		return new ResponseEntity<String>("Customer deleted successfully!.",HttpStatus.OK);
	}
}
