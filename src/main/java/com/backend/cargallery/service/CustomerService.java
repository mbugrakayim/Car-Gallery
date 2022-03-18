package com.backend.cargallery.service;

import java.util.List;

import com.backend.cargallery.model.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	List<Customer> findAllCustomers();
	Customer findByIdCustomer(Long id);
	Customer updateCustomer(Customer customer , Long id);
	void deleteCustomer(Long id);
	
}
