package com.talissonmelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.entities.User;
import com.talissonmelo.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public List<User> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<User> findById(@PathVariable Long userId){
		User user = repository.findById(userId).get();
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		User user = repository.findByEmail(email);
		return ResponseEntity.ok().body(user);
	}

}
