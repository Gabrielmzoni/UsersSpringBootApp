package com.motorola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.findAllUsers();
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<User> getUserbyId(@PathVariable("id") Long id){
		User user = userService.findUserByID(id);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user ){
		User newUser = userService.addUser(user);
		
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> UpdateUser(@RequestBody User user ){
		User newUser = userService.updateUser(user);
		
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id ){
		
		userService.deleteUser(id);
		
		return new ResponseEntity<>(id, HttpStatus.OK);
		
	}
	

}
