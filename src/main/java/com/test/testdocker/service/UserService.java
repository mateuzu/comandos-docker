package com.test.testdocker.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.test.testdocker.controller.dto.PostUserDto;
import com.test.testdocker.entities.User;
import com.test.testdocker.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;

	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public User saveUser(PostUserDto dto) {
		var user = fromDto(dto);
		return repository.save(user);
	}
	
	public User getById(Long id) {
		var user = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
		return user;
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public void deleteUserById(Long id) {
		var userExists = repository.existsById(id);
		
		if(!userExists)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
		
		repository.deleteById(id);
	}
	
	public User fromDto(PostUserDto dto) {
		var user = new User();
		BeanUtils.copyProperties(dto, user);
		return user;	
	}
}
