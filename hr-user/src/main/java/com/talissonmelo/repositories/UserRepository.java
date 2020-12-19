package com.talissonmelo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talissonmelo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
