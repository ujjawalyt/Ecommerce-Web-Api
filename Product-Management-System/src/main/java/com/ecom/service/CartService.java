package com.ecom.service;

import org.springframework.stereotype.Service;

import com.ecom.exceptions.CartException;
import com.ecom.exceptions.LoginException;
import com.ecom.exceptions.ProductNotFoundException;
import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.Cart;

@Service
public interface CartService {

	/**
	 * This method is used to add a product to the cart of a user.
	 * @param productId The ID of the product being added to the cart.
	 * @param userId The ID of the user who owns the cart.
	 * @return The updated cart with the new product added to it.
	 * @throws ProductNotFoundException If the product specified by the productId parameter cannot be found in the system.
	 * @throws UsersNotFoundException If the user specified by the userId parameter cannot be found in the system.
	 * @throws LoginException If the user specified by the userId parameter is not logged in.
	 * @throws CartException If there is an error adding the product to the user's cart.
	 */
	
	public Cart addProductToCart(Long productId, Long userId) throws  ProductNotFoundException,UsersNotFoundException, 
	LoginException , CartException;
	
	
	
}
