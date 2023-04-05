package com.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
 class Address {

	    
	    private String city;
		private String state;
		private String country;
		private String pincode;
}
