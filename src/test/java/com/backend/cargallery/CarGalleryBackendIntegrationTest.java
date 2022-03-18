package com.backend.cargallery;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.cargallery.model.Employee;
import com.backend.cargallery.service.EmployeeService;




@ExtendWith(MockitoExtension.class)
@SpringBootTest(properties = {"spring.profiles.active=dev"})
public class CarGalleryBackendIntegrationTest {
	
	@Autowired
	private EmployeeService employeeService;
	@Test
	public void testFindEmploye() {
	 List<Employee> employees = employeeService.findAllEmployee();
		MatcherAssert.assertThat(employees.size(), Matchers.equalTo(1));
	}
}
