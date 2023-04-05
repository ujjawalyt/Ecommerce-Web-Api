package com.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.Cart;
import com.ecom.model.Orders;
import com.ecom.model.Users;
import com.ecom.repository.CartRepository;
import com.ecom.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private CartRepository cartRepository;
	

	@Override
	public Users addNewUsers(Users users) throws UsersNotFoundException {
	Users user  = usersRepository.findByMobileNumber(users.getMobileNumber());
		
		if(user!=null) {
			throw new  UsersNotFoundException("Users with this mobile number is Already exists...");
			
		}
		usersRepository.save(users);
		Cart cart = new Cart();
		cart.setUsers(users);
		cartRepository.save(cart);
        user.setCart(cart);
       
       return users;

	}
	
	
	
}
