package com.ecom.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.CartException;
import com.ecom.exceptions.LoginException;
import com.ecom.exceptions.OrderNotFoundException;
import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.Cart;
import com.ecom.model.CurrentUserSession;
import com.ecom.model.Orders;
import com.ecom.model.ProductBill;
import com.ecom.model.Users;
import com.ecom.repository.CartRepository;
import com.ecom.repository.CurrentUserSessionDao;
import com.ecom.repository.OrdersRepository;
import com.ecom.repository.UsersRepository;



@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersRepository orderRepository;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
		
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Orders addOrderFromCart(Orders orders, Long cartId, Long userId)
			throws OrderNotFoundException, CartException, LoginException ,UsersNotFoundException{
	 
		if (cartId == null) {
	        throw new IllegalArgumentException("carttId cannot be null");
	    }
	    if (userId == null) {
	        throw new IllegalArgumentException("userId cannot be null");
	    }
	    
	    Optional<Users> optionalUser = usersRepository.findById(userId);
	    if (!optionalUser.isPresent()) {
	        throw new UsersNotFoundException("User with ID " + userId + " not found");
	    }
	    Users users = optionalUser.get();
	    
	    
	    Optional<CurrentUserSession> isCurrent = currentUserSessionDao.findById(users.getUserId());
	    if(!isCurrent.isPresent()) {
	    	throw new LoginException("User is not Loggin With this userId"+ userId);
	    }
	    
	    Optional<Cart> isCartPresent = cartRepository.findById(cartId);
	    if(!isCartPresent.isPresent()) {
	    	throw new CartException("Cart Not Found With this cartId -"+ cartId);
	    }
//	    if (orders.getProductBill() == null) {
//	        orders.setProductBill(new ProductBill());
//	    }
	    
	    orders.setCart(isCartPresent.get());
	    orders.setUsers(isCartPresent.get().getUsers());
//	    orders.getProductBill().setTotalPrice(isCartPresent.get().getTotalPrice());
		return orderRepository.save(orders);
	}

	@Override
	public Orders viewOrderFromCart(Long orderId, Long userId) throws OrderNotFoundException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}
}
