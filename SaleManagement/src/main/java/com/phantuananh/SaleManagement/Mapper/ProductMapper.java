package com.phantuananh.SaleManagement.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.phantuananh.SaleManagement.DTO.ProductDTO;
import com.phantuananh.SaleManagement.Entity.Product;

@Mapper
public interface ProductMapper {
	
		ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
		ProductDTO toProductDTO(Product product);

	    List<ProductDTO> toProductDTOs(List<Product> products);

	    Product toProduct(ProductDTO productDTO);
}
