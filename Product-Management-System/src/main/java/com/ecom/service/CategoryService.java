package com.ecom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.exceptions.AdminNotFoundException;
import com.ecom.exceptions.CategoryNotFoundException;
import com.ecom.model.Category;

@Service
public interface CategoryService {
	
	/**
	 * This method is used to add a new category to the system.
	 * @param adminKey The authentication key for the administrator who is adding the category.
	 * @param category The category object containing the information about the new category being added.
	 * @return The new category object that was added to the system.
	 * @throws AdminNotFoundException If the administrator specified by the adminKey parameter cannot be found in the system.
	 * @throws CategoryNotFoundException If the category specified in the category parameter cannot be found in the system.
	 */

	public Category addNewCategory(String adminKey,Category category)
			throws AdminNotFoundException,CategoryNotFoundException;
	
	/**
	 * This method is used to update an existing category in the system.
	 * @param adminKey The authentication key for the administrator who is updating the category.
	 * @param categoryId The ID of the category being updated.
	 * @param category The updated category object containing the new information about the category.
	 * @return The updated category object.
	 * @throws AdminNotFoundException If the administrator specified by the adminKey parameter cannot be found in the system.
	 * @throws CategoryNotFoundException If the category specified by the categoryId parameter cannot be found in the system.
	 */
	
	public Category updateCategory(String adminKey, Long categoryId, Category category)
			throws AdminNotFoundException,CategoryNotFoundException;
	
	/**
	 * This method is used to delete a category from the system.
	 * @param adminKey The authentication key for the administrator who is deleting the category.
	 * @param categoryId The ID of the category being deleted.
	 * @return A string confirming that the category was deleted.
	 * @throws AdminNotFoundException If the administrator specified by the adminKey parameter cannot be found in the system.
	 * @throws CategoryNotFoundException If the category specified by the categoryId parameter cannot be found in the system.
	 */
	
	public String   deleteCategory(String adminKey, Long categoryId)
			throws AdminNotFoundException,CategoryNotFoundException;
	
	/**
	 * This method is used to get a list of all the categories in the system.
	 * @param adminKey The authentication key for the administrator requesting the list of categories.
	 * @return A list of all the categories in the system.
	 * @throws AdminNotFoundException If the administrator specified by the adminKey parameter cannot be found in the system.
	 * @throws CategoryNotFoundException If there are no categories in the system.
	 */
	public List<Category> getAllCategory(String adminKey)
			throws AdminNotFoundException,CategoryNotFoundException;
	
	/**
	 * This method is used to find a category by its ID.
	 * @param adminKey The authentication key for the administrator searching for the category.
	 * @param categoryId The ID of the category being searched for.
	 * @return The category object corresponding to the ID specified by the categoryId parameter.
	 * @throws AdminNotFoundException If the administrator specified by the adminKey parameter cannot be found in the system.
	 * @throws CategoryNotFoundException If the category specified by the categoryId parameter cannot be found in the system.
	 */
	
	public Category findByCategoryId(String adminKey, Long categoryId)
			throws AdminNotFoundException,CategoryNotFoundException;
	
	
}
