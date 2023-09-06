package com.example.demo.Delivery;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DeliveryServiceTest {
	private final DeliveryService deliveryService = new DeliveryService();

	@ParameterizedTest
	@MethodSource("dateData")
	void contextLoads(int daysFromNow, boolean expectedResult) {
		LocalDateTime deliveryDate = LocalDateTime.now().plusDays(daysFromNow);
		System.out.println("what is date : " + deliveryDate);
		Delivery delivery = new Delivery(deliveryDate);
		boolean result = deliveryService.IsDeliveryValid(delivery);
		assertEquals(expectedResult, result);
	}

	private static Stream<Arguments> dateData() {
		return Stream.of(
			Arguments.of(-1, false),
			Arguments.of(0, false),
			Arguments.of(1, false),
			Arguments.of(2, true)
		);
	}

}