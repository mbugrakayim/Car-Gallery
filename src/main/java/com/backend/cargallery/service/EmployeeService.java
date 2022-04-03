package com.backend.cargallery.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.backend.cargallery.model.Employee;

public interface EmployeeService {

	List<Employee> findAllEmployee();

	Employee findByIdEmployee(Long id);

	Employee updateEmployee(Long id, Employee employee);

	void deleteEmployee(Long id);

	Employee createEmployee(Employee employee);

	Employee upImageEmployee(Long id, MultipartFile file) throws IOException;

}
