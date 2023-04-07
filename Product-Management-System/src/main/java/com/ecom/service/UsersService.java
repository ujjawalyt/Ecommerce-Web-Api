package com.ecom.service;

import org.springframework.stereotype.Service;

import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.Users;

@Service
public interface UsersService {

	
	public Users addNewUsers(Users users)  throws UsersNotFoundException;
	
	
}
