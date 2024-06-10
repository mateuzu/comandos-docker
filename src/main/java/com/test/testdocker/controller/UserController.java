package com.test.testdocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.testdocker.controller.dto.PostUserDto;
import com.test.testdocker.entities.User;
import com.test.testdocker.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private final UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody PostUserDto dto){
		var user = service.saveUser(dto);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> getUserById(@RequestParam Long id){
		var user = service.getById(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id")Long id){
		service.deleteUserById(id);
		return ResponseEntity.noContent().build();
	}
}
