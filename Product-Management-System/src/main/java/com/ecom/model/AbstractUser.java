package com.ecom.model;


import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AbstractUser {

//	@NotNull(message = " UserName Can't be null.")
//	@NotBlank(message = " UserName Can't be Blank.")
//	@NotEmpty (message = " UserName Can't be Empty.")
	private String username;
	
//	@NotNull(message = " Pssword Can't be null.")
	private String password;
//	
//	@NotNull(message = " Name Can't be null.")
//	@NotBlank(message = " Name Can't be Blank.")
//	@NotEmpty (message = " Name Can't be Empty.")
	private String name;
	
	@Embedded
	private Address address;
//	@NotNull(message = "Mobile Number cannot be null.")
	private String mobileNumber;
	
	
//	@NotNull(message = " password Can't be null.")
	private String email;
	
	
}
