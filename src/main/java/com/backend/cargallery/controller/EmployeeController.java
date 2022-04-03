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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.cargallery.dao.EmployeeRepository;
import com.backend.cargallery.model.Employee;
import com.backend.cargallery.payload.MessageResponse;
import com.backend.cargallery.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRepository employeeRepository;


	@GetMapping
	public ResponseEntity<List<Employee>> findAllEmployees() {
		return new ResponseEntity<List<Employee>>(employeeService.findAllEmployee(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> findByIdEmployee(@PathVariable("id") Long id) {
		return new ResponseEntity<Employee>(employeeService.findByIdEmployee(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,
			@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id, employee) , HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}

	@GetMapping("/employees/{firstName}/{lastName}/{phoneNo}")
	public List<Employee> findByFirstNameAndLastNameAndPhoneNo(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName, @PathVariable("phoneNo") Long phoneNo) {
		return employeeRepository.findByFirstNameAndLastNameAndPhoneNo(firstName, lastName, phoneNo);

	}
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmp(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.createEmployee(employee) , HttpStatus.OK);
	}

	@PutMapping("/create/{id}")
	public ResponseEntity<MessageResponse> upEmploye(@PathVariable("id") Long id,
			 @RequestParam("file") MultipartFile file) {
 
		
		String message = "";
		try {
			employeeService.upImageEmployee(id, file);
			message = "Successfully updated.: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file !";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}
	}


}
