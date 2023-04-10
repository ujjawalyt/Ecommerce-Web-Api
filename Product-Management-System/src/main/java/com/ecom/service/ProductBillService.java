package com.ecom.service;

import org.springframework.stereotype.Service;

import com.ecom.exceptions.BillNotFoundException;
import com.ecom.exceptions.CartException;
import com.ecom.exceptions.LoginException;
import com.ecom.exceptions.OrderNotFoundException;
import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.ProductBill;

@Service
public interface  ProductBillService{
	
	/**

	This method is used to calculate the total bill of a user's order.
	@param bill The ProductBill object to be updated with the total amount.
	@param orderId The ID of the order for which the bill needs to be calculated.
	@param userId The ID of the user who owns the order.
	@return The updated ProductBill object with the total amount calculated.
	@throws OrderNotFoundException If the order specified by the orderId parameter cannot be found in the system.
	@throws UsersNotFoundException If the user specified by the userId parameter cannot be found in the system.
	@throws LoginException If the user specified by the userId parameter is not logged in.
	*/
	public ProductBill totalBillOfUser(ProductBill bill, Long orderId ,Long userId)
			throws OrderNotFoundException,CartException,LoginException,UsersNotFoundException;
	
	
	
	/**
	 * 
	 *This method is used to retrieve the details of a product bill by its ID and the ID of the user who owns it.
     @param billId The ID of the product bill to be retrieved.
     @param userId The ID of the user who owns the product bill.
     @return The ProductBill object containing the details of the product bill.
     @throws BillNotFoundException If the product bill specified by the billId parameter cannot be found in the system.
     @throws UsersNotFoundException If the user specified by the userId parameter cannot be found in the system.
     @throws LoginException If the user specified by the userId parameter is not logged in.
	 */
	public ProductBill viewBillById(Long billId,Long userId)
			throws BillNotFoundException,LoginException,UsersNotFoundException;;
	
	
	
}
