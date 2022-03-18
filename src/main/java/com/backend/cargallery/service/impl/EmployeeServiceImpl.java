package com.backend.cargallery.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.cargallery.dao.EmployeeRepository;
import com.backend.cargallery.exception.NotFoundException;
import com.backend.cargallery.model.Employee;
import com.backend.cargallery.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
	public Employee saveEmployee(Employee employee , MultipartFile file) throws IOException {
		Employee emp = new Employee();
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setPhoneNo(employee.getPhoneNo());
		emp.setAddress(employee.getAddress());
		emp.setPrize(employee.getPrize());
		emp.setSalary(employee.getSalary());
		emp.setImages(file.getBytes());
		return employeeRepository.save(emp);
	}
	@Override
	public List<Employee> findAllEmployee() {
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee findByIdEmployee(Long id) {
		
		return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employe Not Found with id: " +id));
	}

	@Override
	public Employee updateEmployee(MultipartFile file ,Employee employee, Long id) throws IOException {
		Employee emp = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employe Not Found with id: " +id));
		byte[] image = file.getBytes();
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setPhoneNo(employee.getPhoneNo());
		emp.setAddress(employee.getAddress());
		emp.setPrize(employee.getPrize());
		emp.setSalary(employee.getSalary());
		emp.setImages(image);
		return employeeRepository.save(emp);
		
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employe Not Found with id: " +id));
		employeeRepository.deleteById(id);

	}

}
