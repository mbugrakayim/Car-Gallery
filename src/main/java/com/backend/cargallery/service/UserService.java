package com.backend.cargallery.service;

import java.util.List;


import com.backend.cargallery.model.User;
import com.backend.cargallery.payload.Singup;

public interface UserService  {
	
	User saveUser(User user);
	
	User createUser(Singup user);

	List<User> findAllUser();

	User findByIdUser(Long id);

	User updateUser(Singup user, Long id);

	void deleteUser(Long id);
	
	User findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String mail);

}
