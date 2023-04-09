package com.ecom.service;

import org.springframework.stereotype.Service;

import com.ecom.exceptions.AdminNotFoundException;
import com.ecom.model.Admin;

@Service
public interface AdminSevice {

	
	/**

	This method is used to save a new administrator's details to the system.
	@param admin The Admin object containing the details of the new administrator.
	@return The saved Admin object.
	@throws AdminNotFoundException If the specified administrator cannot be found in the system.
	*/
	public Admin saveNewAdminDetails(Admin admin) throws AdminNotFoundException;
	
	/**

	This method is used to update an existing administrator's details in the system.
	@param key The authentication key for the administrator making the update.
	@param admin The Admin object containing the updated details.
	@return The updated Admin object.
	@throws AdminNotFoundException If the specified administrator cannot be found in the system.
	*/
	public Admin updateAdmin(String key , Admin admin) throws AdminNotFoundException;
	
	
	/**

	This method is used to delete an existing administrator from the system.
	@param key The authentication key for the administrator making the delete request.
	@return A message indicating whether or not the administrator was successfully deleted.
	@throws AdminNotFoundException If the specified administrator cannot be found in the system.
	*/
	public String deleteAdmin(String key)throws AdminNotFoundException;
	
}
