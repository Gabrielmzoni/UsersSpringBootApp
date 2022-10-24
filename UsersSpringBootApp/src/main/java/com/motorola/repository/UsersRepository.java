package com.motorola.repository;

import java.util.List;

import com.motorola.model.User;

public interface UsersRepository {

	// creating convention methods to manage data
	User addUser(User user);

	List<User> findAllUsers();

	User updateUser(User user);

	void deleteUser(Long id);

	User findUserById(Long id);

}