package com.demo.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.restaurant.dto.OrderResponseDTO;
import com.demo.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello Restarurant....";
	}
	
	@GetMapping("/orders/status/{orderId}")
	public OrderResponseDTO getOrders(@PathVariable String orderId)
	{
		return restaurantService.getOrders(orderId);
	}
}
