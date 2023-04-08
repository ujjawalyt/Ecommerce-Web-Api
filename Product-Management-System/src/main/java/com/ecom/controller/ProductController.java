package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.exceptions.AdminNotFoundException;
import com.ecom.exceptions.CategoryNotFoundException;
import com.ecom.exceptions.ProductNotFoundException;
import com.ecom.model.Product;
import com.ecom.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/ecom/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/save/{categoryId}/{adminKey}")
	public ResponseEntity<Product> addNewProductHandler
						(@PathVariable("categoryId") Long categoryId,@PathVariable("adminKey") String adminKey, @RequestBody Product product)
						throws ProductNotFoundException,CategoryNotFoundException,AdminNotFoundException{
		return new ResponseEntity<Product>(productService.addNewProduct(product, categoryId, adminKey),HttpStatus.CREATED);
	}
	
	
}
