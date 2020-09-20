package com.phantuananh.SaleManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phantuananh.SaleManagement.Entity.Product;



public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
