package com.ecom.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

//	   @NotNull(message = "City Can't be null.")
//	   @NotBlank(message = "City Can't be Blank.")
//	   @NotEmpty (message = "City Can't be Empty.")
	    private String city;
	   
//	    @NotNull(message = "State Can't be null.")
//		@NotBlank(message = "State Can't be Blank.")
//		@NotEmpty (message = "State Can't be Empty.")
		private String state;
	    
//		@NotNull(message = "Country Can't be null.")
//		@NotBlank(message = "Country Can't be Blank.")
//		@NotEmpty (message = "Country Can't be Empty.")
		private String country;
		
//		@NotNull(message = "Pincode Can't be null.")
//		@NotBlank(message = "Pincode Can't be Blank.")
//		@NotEmpty (message = "Pincode Can't be Empty.")
		private String pincode;
}
