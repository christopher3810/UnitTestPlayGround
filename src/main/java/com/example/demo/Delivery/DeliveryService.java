package com.example.demo.Delivery;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
	public boolean IsDeliveryValid(Delivery delivery){
		LocalDate deliveryDay = delivery.getDate().toLocalDate();
		return !deliveryDay.isBefore(LocalDate.now().plusDays(2));
	}
}
