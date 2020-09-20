package com.phantuananh.SaleManagement.API;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phantuananh.SaleManagement.DTO.ProductDTO;
import com.phantuananh.SaleManagement.Entity.Product;
import com.phantuananh.SaleManagement.Mapper.ProductMapper;
import com.phantuananh.SaleManagement.Service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor

@RestController
	public class ProductAPI {
		@Autowired
    	private ProductService productService;
		
	    private ProductMapper productMapper;

//	    @GetMapping("/getPro/{id}")
//	    public ProductDTO getProductById(@PathVariable Long id) {
//	    	Product product = productService.get(id);
//	    	return productMapper.INSTANCE.toProductDTO(product);
//	    }

	    @GetMapping("/products")
	    public ResponseEntity<List<ProductDTO>> findAll() {
	        return ResponseEntity.ok(productMapper.toProductDTOs(productService.findAll2()));
	    }

	    @PostMapping("/addProduct")
	    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
	        productService.save(productMapper.toProduct(productDTO));

	        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
	    }

	    @GetMapping("/getPro/{id}")
//	    public ProductDTO getProductById(@PathVariable(name = "id") Long id) {
//	    	return productMapper.toProductDTO(productService.get(id));
//	    }
	    public ResponseEntity<ProductDTO> findById(@PathVariable(name = "id") Long id) {
	        Optional<Product> product = productService.findById(id);

	        return ResponseEntity.ok(productMapper.toProductDTO(product.get()));
	    }

	    @PutMapping("/update")
	    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO) {
	        Product product = productMapper.toProduct(productDTO);

	        productService.updateProduct(product);

	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<ProductDTO> delete(@PathVariable Long id) {
	        productService.deleteById(id);

	        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	    }
}
