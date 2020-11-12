package com.talissonmelo.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private Double dailyIncome;
	private Integer days;

	public Double getTotal() {
		return days * dailyIncome;
	}
}
