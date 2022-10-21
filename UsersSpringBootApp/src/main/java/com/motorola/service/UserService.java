package com.motorola.service;

import java.util.List;

import com.motorola.model.User;

public interface UserService {

	User addUser(User user);

	List<User> findAllUsers();

}