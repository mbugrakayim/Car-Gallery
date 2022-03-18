package com.backend.cargallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.backend.cargallery.model.Employee;
import com.backend.cargallery.payload.MessageResponse;
import com.backend.cargallery.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	
	
	@PostMapping("/register")
	public  ResponseEntity<MessageResponse> saveCustomer(@RequestBody Employee employee ,@RequestParam("file") MultipartFile file){
		String message = "";
		try {
			employeeService.saveEmployee(employee , file);
			message = "Uploaded the file successfully. ";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file! " ;
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}
	}
	
	@GetMapping
	public List<Employee> findAllEmployees(){
		return employeeService.findAllEmployee();
	}


	@GetMapping("{id}")
	public ResponseEntity<Employee> findByIdEmployee(@PathVariable("id") Long id){
		return new ResponseEntity<Employee>(employeeService.findByIdEmployee(id),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public @ResponseBody ResponseEntity<MessageResponse> updateEmployee(@PathVariable("id") Long id , Employee employee ,@RequestParam("file") MultipartFile file){
		
		String message = "";
		try {
			employeeService.updateEmployee(file, employee , id);
			message = "Successfully updated.: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!.",HttpStatus.OK);
	}
	
	
	
}
