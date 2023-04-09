package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.exceptions.CartException;
import com.ecom.exceptions.LoginException;
import com.ecom.exceptions.ProductNotFoundException;
import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.Cart;
import com.ecom.service.CartService;

@RestController
@RequestMapping("/ecom/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/add/{productId}/{userId}")
	public ResponseEntity<Cart> addToCartHandler(Long productId,Long userId) throws   ProductNotFoundException,UsersNotFoundException, 
	LoginException , CartException{
		
		Cart cart = cartService.addProductToCart(productId, userId);
		return new ResponseEntity<Cart>(cart,HttpStatus.CREATED);
	}
}
