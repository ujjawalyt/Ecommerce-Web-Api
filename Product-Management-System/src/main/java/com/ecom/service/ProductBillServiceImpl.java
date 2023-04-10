package com.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.AdminNotFoundException;
import com.ecom.exceptions.CartException;
import com.ecom.exceptions.CategoryNotFoundException;
import com.ecom.exceptions.LoginException;
import com.ecom.exceptions.OrderNotFoundException;
import com.ecom.exceptions.ProductNotFoundException;
import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.CurrentUserSession;
import com.ecom.model.Orders;
import com.ecom.model.Product;
import com.ecom.model.ProductBill;
import com.ecom.model.Users;
import com.ecom.repository.CartRepository;
import com.ecom.repository.CurrentUserSessionDao;
import com.ecom.repository.OrdersRepository;
import com.ecom.repository.ProductBillRepository;
import com.ecom.repository.UsersRepository;

@Service
public class ProductBillServiceImpl implements ProductBillService{

	
	@Autowired
	private OrdersRepository orderRepository;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
		
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductBillRepository productBillRepository;

	@Override
	public ProductBill totalBillOfUser(ProductBill bill, Long orderId ,Long userId)
			throws OrderNotFoundException,CartException,LoginException,UsersNotFoundException{
		
		if (orderId == null) {
	        throw new IllegalArgumentException("productId cannot be null");
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
	    
	    Optional<Orders> isPresentOrder  = orderRepository.findById(orderId);
	    
	    if(!isPresentOrder.isPresent()) {
	    	throw new OrderNotFoundException("order id is not foud with this orderId -"+ orderId);
	    }
	    
	    bill.setOrders(isPresentOrder.get());
	    bill.setTotalItem(isPresentOrder.get().getCart().getTotalQuantity());
	    bill.setTotalPrice(isPresentOrder.get().getCart().getTotalPrice());
	    
	    
	return   productBillRepository.save(bill);
	}


}



