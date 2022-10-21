package com.motorola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.motorola.model.User;
import com.motorola.service.UserService;


@RestController
@RequestMapping("/user")
public class UserResource {
	
	private UserService userService;
	
	@Autowired
	public UserResource(UserService userService) {
		this.userService = userService;

	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllEmployees(){
		List<User> users = userService.findAllUsers();
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addEmployee(@RequestBody User user ){
		User newUser = userService.addUser(user);
		
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	
	
	

}
