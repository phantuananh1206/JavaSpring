package com.phantuananh.SaleManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phantuananh.SaleManagement.Entity.Category;
import com.phantuananh.SaleManagement.Entity.Product;



public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	@Query("FROM Product P WHERE P.category.id=:id ")
	List<Product> findByCartId(@Param("id") Long catid);
}
