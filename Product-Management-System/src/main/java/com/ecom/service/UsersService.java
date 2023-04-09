package com.ecom.service;

import org.springframework.stereotype.Service;

import com.ecom.dto.UsersDto;
import com.ecom.exceptions.LoginException;
import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.Users;

@Service
public interface UsersService {

	
	/**

	This method is used to add a new user to the system.
	@param users The users parameter contains the information about the user being added.
	@return The Users object representing the newly added user.
	@throws UsersNotFoundException If the user cannot be added to the system.
	*/
	public Users addNewUsers(Users users)  throws UsersNotFoundException;
	
	/**

	This method is used to update an existing user in the system.
	@param userId The ID of the user being updated.
	@param usersDto The UsersDto object containing the updated information for the user.
	@return The updated UsersDto object.
	@throws UsersNotFoundException If the user specified by the userId parameter cannot be found in the system.
	@throws LoginException If there is an authentication error while attempting to update the user.
	*/
	public UsersDto updateUser(Long userId, UsersDto usersDto) throws UsersNotFoundException,LoginException;
	
	
	/**

	This method is used to delete a user from the system.
	@param userId The ID of the user being deleted.
	@return A message indicating whether or not the user was successfully deleted.
	@throws UsersNotFoundException If the user specified by the userId parameter cannot be found in the system.
	@throws LoginException If there is an authentication error while attempting to delete the user.
	*/
	public String deleteUser(Long userId) throws UsersNotFoundException ,LoginException;
	
	
}
