package com.ecom.service;

import org.springframework.stereotype.Service;

import com.ecom.dto.AdminLoginDto;
import com.ecom.exceptions.AdminNotFoundException;

@Service
public interface AdminLoginService {

	/**
	 * This method is used to log into an admin account.
	 * @param adminLoginDto The data transfer object containing the login information for the Admin.
	 * @return An authentication key used to authenticate requests to the system.
	 * @throws AdminNotFoundException If the admin specified in the login information cannot be found in the system.
	 * 
	 */
	
	public String logIntoAccount(AdminLoginDto adminLoginDto) throws AdminNotFoundException;
	
	/**

	This method is used to log out an admin from their account.
	@param key The authentication key of the admin who is logging out.
	@return A message indicating that the logout was successful.
	@throws AdminNotFoundException If the admin specified by the key parameter cannot be found in the system.
	*/
	
	public String logoutFromAccount(String key) throws AdminNotFoundException;
	
	
}
