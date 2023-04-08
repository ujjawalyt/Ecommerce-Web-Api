package com.ecom.service;

import org.springframework.stereotype.Service;

import com.ecom.exceptions.AdminNotFoundException;
import com.ecom.exceptions.CategoryNotFoundException;
import com.ecom.exceptions.ProductNotFoundException;
import com.ecom.model.Product;

@Service
public interface ProductService {

	public Product addNewProduct(Product product,Long categoryId, String key) 
			throws ProductNotFoundException,CategoryNotFoundException,AdminNotFoundException;
}
