package com.ecom.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.Users;
import com.ecom.service.UsersService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/ecom/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@PostMapping("/add")
	private ResponseEntity<Users> my_InsertNewUsersHandler( @RequestBody Users users) throws UsersNotFoundException{
		
		return new ResponseEntity<Users>(usersService.addNewUsers(users),HttpStatus.CREATED);
		
	}
	
}
