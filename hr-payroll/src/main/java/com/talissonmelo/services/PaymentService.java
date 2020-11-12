package com.talissonmelo.services;

import org.springframework.stereotype.Service;

import com.talissonmelo.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, int days) {
		return new Payment("Talisson", 15.00, days);
	}
}
