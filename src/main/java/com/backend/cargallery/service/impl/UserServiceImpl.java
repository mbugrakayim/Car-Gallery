package com.backend.cargallery.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.cargallery.dao.RoleRepository;
import com.backend.cargallery.dao.UserRepository;
import com.backend.cargallery.exception.NotFoundException;
import com.backend.cargallery.model.Role;
import com.backend.cargallery.model.URole;
import com.backend.cargallery.model.User;
import com.backend.cargallery.payload.Singup;
import com.backend.cargallery.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User createUser(Singup user) {

		User user1 = new User();
		user1.setEmail(user.getEmail());
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setPassword(encoder.encode(user.getPassword()));
		user1.setUsername(user.getUsername());
		Set<String> strRole = user.getRole();
		Set<Role> roles = new HashSet<Role>();

		if (strRole == null) {
			Role userRole = roleRepository.findByName(URole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRole.forEach(role -> {
				switch (role.toString()) {
				case "admin":
					Role adminRole = roleRepository.findByName(URole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				case "employee":
					Role modRole = roleRepository.findByName(URole.ROLE_EMPLOYEE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);
					break;
				default:
					Role userRole = roleRepository.findByName(URole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		user1.setRoles(roles);
		return userRepository.save(user1);
	}

	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User findByIdUser(Long id) {

		return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found with id: " + id));
	}

	@Override
	public User updateUser(Singup user, Long id) {
		User user1 = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User Not Found With id: " + id));
		user1.setFirstName(user.getFirstName());

		user1.setLastName(user.getLastName());
		
		user1.setEmail(user.getEmail());
		
		user1.setUsername(user.getUsername());

		user1.setPassword(encoder.encode(user.getPassword()));
		
		Set<String> strRole = user.getRole();
		
		Set<Role> roles = new HashSet<Role>();

		if (strRole == null) {
			Role userRole = roleRepository.findByName(URole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRole.forEach(role -> {
				switch (role.toString()) {
				case "admin":
					Role adminRole = roleRepository.findByName(URole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				case "employee":
					Role modRole = roleRepository.findByName(URole.ROLE_EMPLOYEE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);
					break;
				default:
					Role userRole = roleRepository.findByName(URole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		user1.setRoles(roles);
		userRepository.save(user1);
		return user1;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found with id:" + id));
		userRepository.deleteById(id);

	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new NotFoundException("User not found with username:" + username));
	}

	@Override
	public Boolean existsByUsername(String username) {
		if (userRepository.existsByUsername(username)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Boolean existsByEmail(String mail) {
		if (userRepository.existsByEmail(mail)) {
			return true;
		} else {
			return false;
		}
	}

}
