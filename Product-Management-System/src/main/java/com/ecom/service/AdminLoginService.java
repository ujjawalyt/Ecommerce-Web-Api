package com.ecom.service;

import org.springframework.stereotype.Service;

import com.ecom.exceptions.AdminNotFoundException;
import com.ecom.model.AdminLoginDto;

@Service
public interface AdminLoginService {

	public String logIntoAccount(AdminLoginDto adminLoginDto) throws AdminNotFoundException;
	public String logoutFromAccount(String key) throws AdminNotFoundException;
	
	
}
