package com.ecom.service;

import org.springframework.stereotype.Service;

import com.ecom.exceptions.CartException;
import com.ecom.exceptions.LoginException;
import com.ecom.exceptions.OrderNotFoundException;
import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.Orders;

@Service
public interface OrderService {
	
	/**
    This method is used to add an order to the cart of a user.
	@param orders The order to be added to the cart.
	@param cartId The ID of the cart to which the order should be added.
	@param userId The ID of the user who owns the cart.
	@return The updated cart with the new order added to it.
	@throws OrderNotFoundException If the order specified by the orderId parameter cannot be found in the system.
	@throws CartException If there is an error adding the order to the user's cart.
	@throws LoginException If the user specified by the userId parameter is not logged in.
	@throws UsersNotFoundException If the user specified by the userId parameter cannot be found in the system.
	*/

    public Orders addOrderFromCart(Orders orders, Long cartId ,Long userId)
    		throws OrderNotFoundException,CartException,LoginException,UsersNotFoundException;
    
    /**

    This method is used to view an order from the cart of a user.
    @param orderId The ID of the order to be viewed.
    @param userId The ID of the user who owns the cart.
    @return The order to be viewed.
    @throws OrderNotFoundException If the order specified by the orderId parameter cannot be found in the system.
    @throws LoginException If the user specified by the userId parameter is not logged in.
    @throws UsersNotFoundException If the user specified by the userId parameter cannot be found in the system.
    */
	
	public Orders viewOrderFromCart(Long orderId, Long userId)
			throws OrderNotFoundException,LoginException,UsersNotFoundException;
	
	/**

	This method is used to update the status of an order.
	@param orderId The ID of the order to be updated.
	@param status The new status of the order.
	@return The updated order.
	@throws OrderNotFoundException If the order specified by the orderId parameter cannot be found in the system.
	*/
	
	public Orders updateOrderStatus(Long orderId, String status)
			throws OrderNotFoundException;
	
	/**

	This method is used to delete an order from a user's cart.
	@param orderId The ID of the order to be deleted.
	@param userId The ID of the user who owns the cart.
	@return The deleted order.
	@throws OrderNotFoundException If the order specified by the orderId parameter cannot be found in the system.
	@throws UsersNotFoundException If the user specified by the userId parameter cannot be found in the system.
	@throws LoginException If the user specified by the userId parameter is not logged in.
	*/
	
	public Orders deleteOrderFromCart(Long orderId, Long userId)
			throws OrderNotFoundException,LoginException,UsersNotFoundException;
}
