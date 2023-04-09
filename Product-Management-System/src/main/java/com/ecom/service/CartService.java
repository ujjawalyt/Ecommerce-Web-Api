package com.ecom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.exceptions.CartException;
import com.ecom.exceptions.LoginException;
import com.ecom.exceptions.ProductNotFoundException;
import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.Cart;
import com.ecom.model.Product;

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
	
	public Cart addProductToCart(Long productId, Long userId) 
			throws  ProductNotFoundException,UsersNotFoundException, LoginException , CartException;
	
	/**

	This method is used to remove a product from a user's cart.
	@param productId The ID of the product being removed.
	@param userId The ID of the user who's cart is being modified.
	@return A message indicating whether or not the product was successfully removed from the user's cart.
	@throws ProductNotFoundException If the product specified by the productId parameter cannot be found in the system.
	@throws UsersNotFoundException If the user specified by the userId parameter cannot be found in the system.
	@throws LoginException If there is an authentication error while attempting to modify the user's cart.
	@throws CartException If there is an error while attempting to modify the user's cart.
	*/
	
	public String deleteProductFromCart(Long productId, Long userId)
			throws  ProductNotFoundException,UsersNotFoundException, LoginException , CartException;
	
	/**

	This method is used to increase the quantity of a product in the cart of a user.
	@param productId The ID of the product whose quantity is being increased.
	@param quantity The quantity to increase the product by.
	@param userId The ID of the user whose cart is being updated.
	@return A message indicating whether or not the product quantity was successfully increased.
	@throws ProductNotFoundException If the product specified by the productId parameter cannot be found in the system.
	@throws UsersNotFoundException If the user specified by the userId parameter cannot be found in the system.
	@throws LoginException If there is an authentication error while attempting to update the user's cart.
	@throws CartException If there is an error while attempting to update the user's cart.
	*/
	
     public String increaseProductQuantity(Long productId, int quantity,Long userId)
    		 throws  ProductNotFoundException,UsersNotFoundException, LoginException , CartException;
     
     
     /**

     This method is used to decrease the quantity of a product in a user's cart.
     @param productId The ID of the product being updated.
     @param quantity The quantity to decrease by.
     @param userId The ID of the user who owns the cart.
     @return A message indicating whether or not the product quantity was successfully decreased.
     @throws ProductNotFoundException If the product specified by the productId parameter cannot be found in the system.
     @throws UsersNotFoundException If the user specified by the userId parameter cannot be found in the system.
     @throws LoginException If there is an authentication error while attempting to update the user's cart.
     @throws CartException If the user's cart is empty or the product quantity to decrease is greater than the current quantity.
     */
	
	public String decreaseProductQuantity(Long productId, int quantity,Long userId)
			throws  ProductNotFoundException,UsersNotFoundException, LoginException , CartException;
	
	
	/**
	* This method is used to clear a user's cart by removing all products.
	* @param userId The ID of the user who owns the cart.
	* @return A message indicating whether or not the cart was successfully cleared.
	* @throws UsersNotFoundException If the user specified by the userId parameter cannot be found in the system.
	* @throws LoginException If there is an authentication error while attempting to clear the user's cart.
	* @throws CartException If the user's cart is already empty.
	*/
	 public String clearProductFromCart(Long userId )throws CartException,LoginException,UsersNotFoundException;
	 
	 
	 /**
	 This method is used to view all products in a user's cart.
	 @param userId The ID of the user who owns the cart.
	 @param cartId The ID of the cart containing the products.
	 @return A List of products in the user's cart.
	 @throws CartException If the user's cart is empty or cannot be found.
	 @throws LoginException If there is an authentication error while attempting to view the user's cart.
	 @throws UsersNotFoundException If the user specified by the userId parameter cannot be found in the system.
	 */
	 
	 public List<Product> viewAllProductFromCart(Long userId,Long cartId )throws CartException,LoginException,UsersNotFoundException;
	
	
	
}
