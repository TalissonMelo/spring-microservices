package com.talissonmelo.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Worker implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Double dailyIncome;
}
