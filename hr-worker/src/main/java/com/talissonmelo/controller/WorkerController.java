package com.talissonmelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private WorkerRepository repository;

	@GetMapping
	public List<Worker> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/{workerId}")
	public ResponseEntity<Worker> findById(@PathVariable Long workerId) {

//		try {
//			Thread.sleep(3000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		log.info("PORT = " + env.getProperty("local.server.port"));
		Worker worker = repository.findById(workerId).orElse(null);
		return ResponseEntity.ok().body(worker);
	}
}
