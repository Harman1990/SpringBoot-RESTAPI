package com.harmanLabs.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service=service;
	}
	
	@GetMapping(path="/users")
	public List<User> retrieveAllUser(){
		
		return service.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User retrieveUser(@PathVariable Integer id) {
		
		User user= service.findOne(id);
		
		if(user==null) {
			throw new UserNotFoundException("id: "+id);
		}
		
		return user;
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		
		service.deleteByID(id);
		
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		User savedUser=service.save(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}