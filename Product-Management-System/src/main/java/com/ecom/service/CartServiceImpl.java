package com.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.CartException;
import com.ecom.exceptions.LoginException;
import com.ecom.exceptions.ProductNotFoundException;
import com.ecom.exceptions.UsersNotFoundException;
import com.ecom.model.Cart;
import com.ecom.model.CurrentUserSession;
import com.ecom.model.Product;
import com.ecom.model.Users;
import com.ecom.repository.CartRepository;
import com.ecom.repository.CurrentUserSessionDao;
import com.ecom.repository.ProductRepository;
import com.ecom.repository.UsersRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	@Autowired 
	private ProductRepository productRepository;
	
	
	public Double cartTotal(List<Product> product) {
	    Double total = 0.0;
	    for (Product p : product) {
	        if (p.getQuantity() != 0) {
	            total += p.getPrice() * p.getQuantity();
	        }
	    }
	    return total;
	}

	public int cartTotalQuantity(List<Product> product) {
	    int total = 0;
	    for (Product p : product) {
	        if (p.getQuantity() != 0) {
	            total += p.getQuantity();
	        }
	    }
	    return total;
	}

	@Override
	public Cart addProductToCart(Long productId, Long userId)
			throws ProductNotFoundException, UsersNotFoundException, CartException ,LoginException{
		
		if (productId == null) {
	        throw new IllegalArgumentException("productId cannot be null");
	    }
	    if (userId == null) {
	        throw new IllegalArgumentException("userId cannot be null");
	    }
		
	    Optional<Product> optionalProduct = productRepository.findById(productId);
	    if (!optionalProduct.isPresent()) {
	        throw new ProductNotFoundException("Product with ID " + productId + " not found");
	    }
	    Product product = optionalProduct.get();
	    
	    Optional<Users> optionalUser = usersRepository.findById(userId);
	    if (!optionalUser.isPresent()) {
	        throw new UsersNotFoundException("User with ID " + userId + " not found");
	    }
	    Users users = optionalUser.get();
	    
	    
	    Optional<CurrentUserSession> isCurrent = currentUserSessionDao.findById(users.getUserId());
	    if(!isCurrent.isPresent()) {
	    	throw new LoginException("User is not Loggin With this userId"+ userId);
	    }
	    
	   
	    Cart cart = users.getCart();
	    List<Product> products = cart.getProduct();
	    boolean found = false;
	    for (Product p : products) {
	        if (p.getProductId().equals(product.getProductId())) {
	            found = true;
	            p.setQuantity(p.getQuantity() + 1);
	            break;
	        }
	    }

	    // If the product is not already in the cart, add it with quantity 1
	    if (!found) {
	        product.setQuantity(1);
//	        products.add(product);
       cart.getProduct().add(product);
	        
	    }
	    
	    cart.setTotalPrice(cartTotal(cart.getProduct()));
	    cart.setTotalQuantity(cartTotalQuantity(cart.getProduct()));

	    cartRepository.save(cart);
	    return cart;
	    
		
	}

	@Override
	public String deleteProductFromCart(Long productId, Long userId)
			throws ProductNotFoundException, UsersNotFoundException, LoginException, CartException {
		
		if (productId == null) {
	        throw new IllegalArgumentException("productId cannot be null");
	    }
	    if (userId == null) {
	        throw new IllegalArgumentException("userId cannot be null");
	    }
		
	    Optional<Product> optionalProduct = productRepository.findById(productId);
	    if (!optionalProduct.isPresent()) {
	        throw new ProductNotFoundException("Product with ID " + productId + " not found");
	    }
	    Product product = optionalProduct.get();
	    
	    Optional<Users> optionalUser = usersRepository.findById(userId);
	    if (!optionalUser.isPresent()) {
	        throw new UsersNotFoundException("User with ID " + userId + " not found");
	    }
	    Users users = optionalUser.get();
	    
	    
	    Optional<CurrentUserSession> isCurrent = currentUserSessionDao.findById(users.getUserId());
	    if(!isCurrent.isPresent()) {
	    	throw new LoginException("User is not Loggin With this userId"+ userId);
	    }
	    
	    Cart cart = users.getCart();
	    if (cart == null) {
	        throw new CartException("Cart not found for user with ID " + userId);
	    }
	    
	    boolean productRemoved =cart.getProduct().removeIf(p-> p.getProductId()==productId);
	   
	    if (!productRemoved) {
	        throw new CartException("Product with ID " + productId + " not found in the user's cart");
	    }

	    cart.setTotalPrice(cartTotal(cart.getProduct()));
	    cart.setTotalQuantity(cartTotalQuantity(cart.getProduct()));
	    cartRepository.save(cart);
	    return "Product with ID " + productId + " has been removed from the users cart";
		
	}

	@Override
	public String increaseProductQuantity(Long productId, int quantity, Long userId)
			throws ProductNotFoundException, UsersNotFoundException, LoginException, CartException {
		
		if (productId == null) {
	        throw new IllegalArgumentException("productId cannot be null");
	    }
	    if (userId == null) {
	        throw new IllegalArgumentException("userId cannot be null");
	    }
		
	    Optional<Product> optionalProduct = productRepository.findById(productId);
	    if (!optionalProduct.isPresent()) {
	        throw new ProductNotFoundException("Product with ID " + productId + " not found");
	    }
	    Product product = optionalProduct.get();
	    
	    Optional<Users> optionalUser = usersRepository.findById(userId);
	    if (!optionalUser.isPresent()) {
	        throw new UsersNotFoundException("User with ID " + userId + " not found");
	    }
	    Users users = optionalUser.get();
	    
	    
	    Optional<CurrentUserSession> isCurrent = currentUserSessionDao.findById(users.getUserId());
	    if(!isCurrent.isPresent()) {
	    	throw new LoginException("User is not Loggin With this userId"+ userId);
	    }
	    
	    Cart cart = users.getCart();
	    if (cart == null) {
	        throw new CartException("Cart not found for user with ID " + userId);
	    }
	    

	    cart.getProduct().forEach(c -> {
	    	
	    if(c.getProductId().equals(productId)) {
	    	c.setQuantity(c.getQuantity()+quantity);
	    	}
	    
	    });
	    
	  
	    cart.setTotalPrice(cartTotal(cart.getProduct()));
	    cart.setTotalQuantity(cartTotalQuantity(cart.getProduct()));
		
		cartRepository.save(cart);
		return "Item added successfully";
	}

	@Override
	public String decreaseProductQuantity(Long productId, int quantity, Long userId)
			throws ProductNotFoundException, UsersNotFoundException, LoginException, CartException {
		
		
		if (productId == null) {
	        throw new IllegalArgumentException("productId cannot be null");
	    }
	    if (userId == null) {
	        throw new IllegalArgumentException("userId cannot be null");
	    }
		
	    Optional<Product> optionalProduct = productRepository.findById(productId);
	    if (!optionalProduct.isPresent()) {
	        throw new ProductNotFoundException("Product with ID " + productId + " not found");
	    }
	    Product product = optionalProduct.get();
	    
	    Optional<Users> optionalUser = usersRepository.findById(userId);
	    if (!optionalUser.isPresent()) {
	        throw new UsersNotFoundException("User with ID " + userId + " not found");
	    }
	    Users users = optionalUser.get();
	    
	    
	    Optional<CurrentUserSession> isCurrent = currentUserSessionDao.findById(users.getUserId());
	    if(!isCurrent.isPresent()) {
	    	throw new LoginException("User is not Loggin With this userId"+ userId);
	    }
	    
	    Cart cart = users.getCart();
	    if (cart == null) {
	        throw new CartException("Cart not found for user with ID " + userId);
	    }
	    

	    cart.getProduct().forEach(c -> {
	    	
	    if(c.getProductId().equals(productId)) {
	    	c.setQuantity(c.getQuantity()-quantity);
	    	}
	    
	    });
	    
	  
	    cart.setTotalPrice(cartTotal(cart.getProduct()));
	    cart.setTotalQuantity(cartTotalQuantity(cart.getProduct()));
		
		 cartRepository.save(cart);
		 return "Item removed successfully";
		
		
		
	}
	    
	    
	    
	

	
}

