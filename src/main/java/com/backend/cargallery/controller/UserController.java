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
import org.springframework.web.bind.annotation.RestController;
import com.backend.cargallery.model.User;
import com.backend.cargallery.payload.Singup;
import com.backend.cargallery.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@PostMapping("/create")
	public ResponseEntity<User> saveUser(@RequestBody Singup user){
		return new ResponseEntity<User>(userService.createUser(user) , HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<User> findAllUser(){
		return userService.findAllUser();
	}


	@GetMapping("{id}")
	public ResponseEntity<User> findByIdUser(@PathVariable("id") Long id){
		return new ResponseEntity<User>(userService.findByIdUser(id),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id , @RequestBody Singup user){
		return new ResponseEntity<User>(userService.updateUser(user, id) , HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return new ResponseEntity<String>("User deleted successfully!.",HttpStatus.OK);
	}
	

}
