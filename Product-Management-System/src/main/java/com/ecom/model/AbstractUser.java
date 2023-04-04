package com.ecom.model;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AbstractUser {

	private String username;
	private String password;
	private String name;
	private String address;
	private String mobileNumber;
	private String email;
	
	
}
