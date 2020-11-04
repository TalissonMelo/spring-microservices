package com.talissonmelo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talissonmelo.entities.Worker;

public interface WorkerRepository  extends JpaRepository<Worker, Long>{

}
