package com.demo.swiggyapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.swiggyapp.client.RestaurantServiceClient;
import com.demo.swiggyapp.dto.OrderResponseDTO;

@Service
public class SwiggyAppService {

	
	@Autowired
	RestaurantServiceClient restaurantServiceClient;
	
	public OrderResponseDTO checkOrderStatus(String orderId) {
        return restaurantServiceClient.fetchOrderStatus(orderId);
    }
}
