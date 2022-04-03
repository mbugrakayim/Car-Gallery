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

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		Employee emp = new Employee();
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setPhoneNo(employee.getPhoneNo());
		emp.setAddress(employee.getAddress());
		emp.setPrize(employee.getPrize());
		emp.setSalary(employee.getSalary());
		emp.setEmail(employee.getEmail());
		emp.setTitle(employee.getTitle());
		return employeeRepository.save(employee);
	}

	@Override
	public Employee upImageEmployee(Long id, MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			Employee emp = employeeRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("Employe Not Found with id: " + id));
			byte[] image = file.getBytes();
			emp.setImages(image);
			return employeeRepository.save(emp);
		} else {
			Employee emp = employeeRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("Employe Not Found with id: " + id));
			emp.setImages(null);
			return employeeRepository.save(emp);
		}

	}

	@Override
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findByIdEmployee(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Employe Not Found with id: " + id));
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee emp = employeeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Employe Not Found with id: " + id));
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setPhoneNo(employee.getPhoneNo());
		emp.setAddress(employee.getAddress());
		emp.setPrize(employee.getPrize());
		emp.setSalary(employee.getSalary());
		emp.setEmail(employee.getEmail());
		emp.setTitle(employee.getTitle());
		return employeeRepository.save(emp);

	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employe Not Found with id: " + id));
		employeeRepository.deleteById(id);

	}

}
