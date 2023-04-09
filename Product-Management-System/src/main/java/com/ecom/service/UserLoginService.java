package com.ecom.service;

import org.springframework.stereotype.Service;

import com.ecom.dto.UserLoginDto;
import com.ecom.exceptions.LoginException;

@Service
public interface UserLoginService {

	
	/**

	This method is used to log into a user account.
	@param userLoginDto The userLoginDto parameter contains the login information (username and password) of the user trying to log in.
	@return An authentication key that can be used for subsequent requests that require authentication.
	@throws LoginException If the username or password provided in the userLoginDto parameter is incorrect.
	@throws UserNotFoundException If the user specified by the username in the userLoginDto parameter cannot be found in the system.
	*/
	public String logIntoAccount(UserLoginDto userLoginDto) throws LoginException;
	
	/**

	This method is used to log out a user from their account.
	@param key The authentication key for the user to be logged out.
	@return A string confirming the successful logout of the user.
	@throws LoginException If the user specified by the key parameter cannot be found in the system.
	*/
	
	public String logoutFromAccount(String key) throws LoginException;
}
