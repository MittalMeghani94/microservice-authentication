package com.demo.swiggyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.swiggyapp.dto.OrderResponseDTO;
import com.demo.swiggyapp.service.SwiggyAppService;

@RestController
@RequestMapping("/swiggy")
public class SwiggyAppController {

	@Autowired
	SwiggyAppService swiggyAppService;
	
	@GetMapping("/hello")
	public String hello() {
		return "swiggy-service........";
	}
	
	@GetMapping("/{orderId}")
	public OrderResponseDTO checkOrderStatus(@PathVariable String orderId) {
	    return swiggyAppService.checkOrderStatus(orderId);
	}
	
}