package com.backend.cargallery.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.cargallery.dao.CustomerRepository;
import com.backend.cargallery.exception.NotFoundException;
import com.backend.cargallery.model.Customer;
import com.backend.cargallery.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findByIdCustomer(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Customer not found with id :" + id));
	}

	@Override
	public Customer updateCustomer(Customer customer , Long id) {
		Customer customer1 = customerRepository.findById(id).orElseThrow(()-> new NotFoundException("Customer not found with id: " +id));
		customer1.setFirstName(customer.getFirstName());
		customer1.setLastName(customer.getLastName());
		customer1.setEmail(customer.getEmail());
		customer1.setAge(customer.getAge());
		customer1.setAddress(customer.getAddress());
		customer1.setDrivingLicence(customer.getDrivingLicence());
		customer1.setPhoneNo(customer.getPhoneNo());
		customer1.setTcNo(customer.getPhoneNo());
		customer1.setPassword(customer.getPassword());
		customerRepository.save(customer1);
		return customer1;
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.findById(id).orElseThrow(()-> new NotFoundException("Customer not found with id:" +id));
		customerRepository.deleteById(id);
		
	}
	

}
