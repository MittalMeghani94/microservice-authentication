package com.demo.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.restaurant.dao.RestaurantOrderDao;
import com.demo.restaurant.dto.OrderResponseDTO;

@Service
public class RestaurantService {

	@Autowired
	RestaurantOrderDao restaurantOrderDao;
	
	public OrderResponseDTO getOrders(String orderId)
	{
		return restaurantOrderDao.getOrders(orderId);
	}
}
