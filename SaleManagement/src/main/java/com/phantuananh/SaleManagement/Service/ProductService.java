package com.phantuananh.SaleManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phantuananh.SaleManagement.Entity.Product;
import com.phantuananh.SaleManagement.Repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class ProductService {
	@Autowired
    private ProductRepository productRepository;

    public List<Product> findAll2() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    
    public Product get(Long id) {
		return productRepository.findById(id).get();
	}
    
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
    
    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null); 
        existingProduct.setDescription(product.getDescription());
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }
}
