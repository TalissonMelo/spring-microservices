package com.talissonmelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.entities.Worker;
import com.talissonmelo.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public List<Worker> findAll(){
		return repository.findAll();
	}
	
	@GetMapping(value = "/{workerId}")
	public ResponseEntity<Worker> findById(@PathVariable Long workerId){
		Worker worker = repository.findById(workerId).orElse(null);
		return ResponseEntity.ok().body(worker);
	}
}
