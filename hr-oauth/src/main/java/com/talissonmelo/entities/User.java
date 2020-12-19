package com.talissonmelo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String email;
	private String password;
	Set<Role> roles = new HashSet<>();
}
