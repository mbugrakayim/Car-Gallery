package com.backend.cargallery.controller;

import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.cargallery.dao.RoleRepository;
import com.backend.cargallery.model.Role;
import com.backend.cargallery.model.URole;
import com.backend.cargallery.model.User;
import com.backend.cargallery.payload.JwtResponse;
import com.backend.cargallery.payload.Login;
import com.backend.cargallery.payload.MessageResponse;
import com.backend.cargallery.payload.Singup;
import com.backend.cargallery.security.JwtUtils;
import com.backend.cargallery.security.UserDetailsImpl;
import com.backend.cargallery.service.impl.UserServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody Login loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody Singup singUp) {
		if (userServiceImpl.existsByUsername(singUp.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}
		if (userServiceImpl.existsByEmail(singUp.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}
		User user = new User(singUp.getUsername(), singUp.getFirstName(), singUp.getLastName(), singUp.getEmail(),
				encoder.encode(singUp.getPassword()));

		Set<String> strRoles = singUp.getRole();
		Set<Role> roles = new HashSet<Role>();
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(URole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
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
		user.setRoles(roles);
		userServiceImpl.saveUser(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logoutUser() {
		ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
				.body(new MessageResponse("You've been signed out!"));
	}

}
