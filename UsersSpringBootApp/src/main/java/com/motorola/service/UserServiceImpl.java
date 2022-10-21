package com.motorola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motorola.model.User;
import com.motorola.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UsersRepository usersRepository;
	
	@Autowired
	public UserServiceImpl(UsersRepository usersRepo) {
		this.usersRepository = usersRepo;
	}
	
	
	@Override
	public User addUser(User user) {
		
		return usersRepository.addUser(user);
	}
	
	@Override
	public List<User> findAllUsers(){
		
		return usersRepository.findAllUsers();
	}


	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return usersRepository.updateUser(user);
	}


	@Override
	public void deleteUser(Long id) {
		
		usersRepository.deleteUser(id);
		
	}
	
	

}
