package com.backend.cargallery.dao.criteria;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.backend.cargallery.model.Employee;

@Repository
public interface EmployeeCriteriaRepository {
	
	List<Employee> findByFirstNameAndLastNameAndPhoneNo(String firstName , String lastName , Long phoneNo);
	
	
	
	
}
