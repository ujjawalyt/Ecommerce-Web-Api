package com.ecom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.exceptions.AdminNotFoundException;
import com.ecom.exceptions.CategoryNotFoundException;
import com.ecom.exceptions.ProductNotFoundException;
import com.ecom.model.Product;

@Service
public interface ProductService {
	
	/**
	 * @param product The product parameter contains the information about the product being added.
 * @param categoryId The ID of the category to which the product belongs.
 * @param key The authentication key used to verify the administrator who is adding the product.
 * 
 * @return The product that was added to the system.
 * 
 * @throws ProductNotFoundException If the product being added cannot be found in the system.
 * @throws CategoryNotFoundException If the category specified by the categoryId parameter cannot be found in the system.
 * @throws AdminNotFoundException If the administrator specified by the key parameter cannot be found in the system.
	 */

	public Product addNewProduct(Product product,Long categoryId, String key) 
			throws ProductNotFoundException,CategoryNotFoundException,AdminNotFoundException;
	
	
	/**
	 * This method is used to delete a product from the system.
	 * 
	 * @param productId The ID of the product being deleted.
	 * @param key The authentication key used to verify the administrator who is deleting the product.
	 * 
	 * @return A message indicating whether the product was successfully deleted or not.
	 * 
	 * @throws ProductNotFoundException If the product specified by the productId parameter cannot be found in the system.
	 * @throws AdminNotFoundException If the administrator specified by the key parameter cannot be found in the system.
	 */
	
	public  String deleteProductByI(Long productId,String key)
			throws ProductNotFoundException,AdminNotFoundException;
	
	/**
	 * This method is used to find a product in the system by its ID. 
	 * @param productId The ID of the product being searched for. 
	 * @return The product with the specified ID. 
	 * @throws ProductNotFoundException If the product specified by the productId parameter cannot be found in the system.
	 */
	
	public Product findProductById(Long ProductId) throws ProductNotFoundException;
	
	
	/**
	 * This method is used to view all the products in the system.
	 * @return A list of all the products in the system.
	 * @throws ProductNotFoundException If there are no products in the system.
	 */
	
	public List<Product> viewAllProduct()throws ProductNotFoundException;
	
	/**
	 * This method is used to find products in the system by their name.
	 * @param productName The name of the product being searched for.
	 * @return A list of products with the specified name.
	 * @throws ProductNotFoundException If no products with the specified name can be found in the system.
	 */
	
	public List<Product> findProductByName(String productName)throws ProductNotFoundException;
	
	
	/**
	 * This method is used to update a product in the system by its ID.
	 * @param productId The ID of the product being updated.
	 * @param adminKey The authentication key used to verify the administrator who is updating the product.
	 * @param product The updated product object containing the new information for the product.
	 * @return The updated product object.
	 * @throws ProductNotFoundException If the product specified by the productId parameter cannot be found in the system.
	 * @throws AdminNotFoundException If the administrator specified by the adminKey parameter cannot be found in the system.
	 */
	
	
	public Product updateProductById(Long ProductId, String adminKey,Product product)
			throws ProductNotFoundException,AdminNotFoundException;
	
	

	/**
	 * This method is used to find all the products in the system and sort them by price. 
	 * @param sortOrder The sorting order for the products (either "ASC" or "DESC").
	 * @return A list of all the products in the system sorted by price in the specified order.
	 * @throws ProductNotFoundException If there are no products in the system.
	 */
	
	public List<Product> findAllProductsSortedByPrice(String sortOrder) 
			throws ProductNotFoundException;
	
	/**
	 * This method is used to find all the products in the system and sort them in ascending order by their rating.
	 * @return A list of all the products in the system sorted by rating in ascending order.
	 * @throws ProductNotFoundException If there are no products in the system.
	 */
	
	public List<Product> findProductsSortedByRatingAsc();
	
	/**
	 * This method is used to find all the products in the system and sort them in descending order by their rating.
	 * @return A list of all the products in the system sorted by rating in descending order. 
	 * @throws ProductNotFoundException If there are no products in the system.
	 */
	
	public List<Product> findProductsSortedByRatingDesc();
	
	
}
