package com.demo.restaurant.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.demo.restaurant.dto.OrderResponseDTO;

@Component
public class RestaurantOrderDao {

	public OrderResponseDTO getOrders(String orderId) {
		System.out.println("order..."+generateOrders().get(orderId));
		return generateOrders().get(orderId);
		
	}

	public Map<String, OrderResponseDTO> generateOrders() {
		Map<String, OrderResponseDTO> orderMap = new HashMap<String, OrderResponseDTO>();
		orderMap.put("1", new OrderResponseDTO("1", "VEG-MEALS", 1, 199, new Date(), "READY", 15));
		orderMap.put("2", new OrderResponseDTO("2", "HYDERABADI DUM BIRYANI", 2, 641, new Date(), "PREPARING", 59));
		orderMap.put("3", new OrderResponseDTO("3", "PANEER BUTTER MASALA", 1, 325, new Date(), "DELIVERED", 0));

		return orderMap;
	}

}
