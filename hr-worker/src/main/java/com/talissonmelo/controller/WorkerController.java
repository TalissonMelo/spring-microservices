package com.talissonmelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.entities.Worker;
import com.talissonmelo.repositories.WorkerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

	@Autowired
	private Environment env;
	
	@Value("${test.config}")
	private String testConfig;

	@Autowired
	private WorkerRepository repository;
	
	@GetMapping(value = "/configs")
	public void getConfigs() {
		log.info("CONFIG = " + testConfig);
		
	}

	@GetMapping
	public List<Worker> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/{workerId}")
	public ResponseEntity<Worker> findById(@PathVariable Long workerId) {
		log.info("PORT = " + env.getProperty("local.server.port"));
		Worker worker = repository.findById(workerId).orElse(null);
		return ResponseEntity.ok().body(worker);
	}
}
