package com.backend.cargallery.service;

import java.util.List;

import com.backend.cargallery.model.User;

public interface UserService {

	User saveUser(User user);

	List<User> findAllUser();

	User findByIdUser(Long id);

	User updateUser(User user, Long id);

	void deleteUser(Long id);

}
