package com.ecom.model.controller;

public class UsersNotFoundException extends Exception {

	public UsersNotFoundException() {
		
	}
	public UsersNotFoundException(String message) {
		super(message);
	}
}
