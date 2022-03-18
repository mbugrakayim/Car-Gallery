package com.backend.cargallery.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.backend.cargallery.model.Employee;


public interface EmployeeService {
	Employee saveEmployee(Employee employee , MultipartFile file) throws IOException;
	List<Employee> findAllEmployee();
	Employee findByIdEmployee(Long id);
	Employee updateEmployee(MultipartFile file,Employee employee , Long id)throws IOException;
	void deleteEmployee(Long id);
}
