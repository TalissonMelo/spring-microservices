package com.talissonmelo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.talissonmelo.entities.User;
import com.talissonmelo.feignclients.UserFeignClients;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserFeignClients feignClient;

	public User findByEmail(String email) {
		User user = feignClient.findByEmail(email).getBody();
		if (user == null) {
			log.info("E-mail not found : " + email);
			throw new IllegalArgumentException("Email not found");
		}

		log.info("E-mail found : " + email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = feignClient.findByEmail(email).getBody();
		if (user == null) {
			log.info("E-mail not found : " + email);
			throw new IllegalArgumentException("Email not found");
		}

		log.info("E-mail found : " + email);
		return user;
	}

}
