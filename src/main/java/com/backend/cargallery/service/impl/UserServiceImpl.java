package com.backend.cargallery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.cargallery.dao.UserRepository;
import com.backend.cargallery.exception.NotFoundException;
import com.backend.cargallery.model.User;
import com.backend.cargallery.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
		UserRepository userRepository;
		@Autowired
		PasswordEncoder encoder;

	
		public UserServiceImpl(UserRepository userRepository) {
			super();
			this.userRepository = userRepository;
		}


		@Override
		public User saveUser(User user) {
			return userRepository.save(user);
		}


		@Override
		public List<User> findAllUser() {
			return userRepository.findAll();
		}


		@Override
		public User findByIdUser(Long id) {
			
			return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found with id: " +id));
		}


		@Override
		public User updateUser(User user, Long id) {
			User user1 = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found With id: " +id));
			user1.setFirstName(user.getFirstName());
			user1.setLastName(user.getLastName());
			user1.setEmail(user.getEmail());
			user1.setUsername(user.getUsername());
			user1.setRoles(user.getRoles());
			user1.setPassword(encoder.encode(user.getPassword()));
			userRepository.save(user1);
			return user1;
		}


		@Override
		public void deleteUser(Long id) {
			userRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found with id:" +id));
			userRepository.deleteById(id);
			
		}
		
		
		
		
		

}
