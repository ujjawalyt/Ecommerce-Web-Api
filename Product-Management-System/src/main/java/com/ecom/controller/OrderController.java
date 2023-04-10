package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.exceptions.CartException;
import com.ecom.exceptions.LoginException;
import com.ecom.exceptions.OrderNotFoundException;
import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.Orders;
import com.ecom.service.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("ecom/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	

	@PostMapping("/{userId}/{cartId}")
	public ResponseEntity<Orders> proceedOrdersFromCart(@PathVariable("userId") Long userId,@PathVariable("cartId") Long cartId,@RequestBody Orders orders)
			throws OrderNotFoundException,CartException,LoginException,UsersNotFoundException{
		
		return new ResponseEntity<Orders>(orderService.addOrderFromCart(orders, cartId, userId),HttpStatus.ACCEPTED);
	}
}
