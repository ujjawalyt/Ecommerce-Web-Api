package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.model.ProductBill;

@Repository
public interface ProductBillRepository extends JpaRepository<ProductBill, Long> {

	
}
