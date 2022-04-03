package com.backend.cargallery.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.cargallery.dao.criteria.EmployeeCriteriaRepository;
import com.backend.cargallery.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> , EmployeeCriteriaRepository{

	//List<Employee> findByFirstNameAndLastNameAndPhoneNo(String firstName , String lastName , Long phoneNo);
	
}
