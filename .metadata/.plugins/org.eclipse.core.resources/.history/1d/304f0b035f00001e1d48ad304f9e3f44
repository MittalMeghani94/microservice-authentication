package com.demo.swiggyapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.swiggyapp.dto.OrderResponseDTO;

@Component
public class RestaurantServiceClient {

	@Autowired
	RestTemplate restTemplate;
	
	private static final String restaurantServiceBaseURL = "http://RESTAURANT-SERVICE";
	
	public OrderResponseDTO fetchOrderStatus(String orderId) {
		
		
		//return restTemplate.getForObject("http://localhost:8000/restaurant/orders/status/"+orderId, OrderResponseDTO.class);
	
		return restTemplate.getForObject(restaurantServiceBaseURL + "/restaurant/orders/status/{orderId}",
				OrderResponseDTO.class,
				orderId);
		
	}
}
