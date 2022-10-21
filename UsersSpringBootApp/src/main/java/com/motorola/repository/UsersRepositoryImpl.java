package com.motorola.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.motorola.model.User;

@Component()
public class UsersRepositoryImpl implements UsersRepository {
	
	//creating a memory managed database with an arrayList
	private List<User> users;
	int currentUserId = 1;
	
	public UsersRepositoryImpl() {
		users = new ArrayList<>();
	}
	
	
	// creating convention methods to manage data
	@Override
	public User addUser(User user) {
		
		user.setId(currentUserId);
		currentUserId++;
		users.add(user);
		
		return user;
		
	}
	
	@Override
	public List<User> findAllUsers(){
		return users;
	}


	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		
		for(User tempUser: users) {
			if (tempUser.getId() == user.getId()) {
				users.remove(tempUser);
				users.add(user);
				break;
			}
			
		}
		
		return user;
		
	}


	@Override
	public void deleteUser(Long id) {
		
		boolean userFound = false;
		
		for(User tempUser: users) {
			if (tempUser.getId() == id) {
				users.remove(tempUser);
				userFound = true;
				break;
			}
			
		}
		
			
	}
	
	
	

}
