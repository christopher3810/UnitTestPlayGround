package com.example.demo.Delivery;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
	public boolean IsDeliveryValid(Delivery delivery){
		return !delivery.getDate().isBefore(LocalDateTime.now().plusDays(2));
	}
}
