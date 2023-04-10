package com.ecom.service;

import org.springframework.stereotype.Service;

import com.ecom.exceptions.CartException;
import com.ecom.exceptions.LoginException;
import com.ecom.exceptions.OrderNotFoundException;
import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.ProductBill;

@Service
public interface  ProductBillService{

	public ProductBill totalBillOfUser(ProductBill bill, Long orderId ,Long userId)
			throws OrderNotFoundException,CartException,LoginException,UsersNotFoundException;
	
	
	
	
	
}