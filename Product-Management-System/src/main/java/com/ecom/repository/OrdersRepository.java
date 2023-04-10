package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.model.Orders;


public interface OrdersRepository extends JpaRepository<Orders, Long> {

	
}
