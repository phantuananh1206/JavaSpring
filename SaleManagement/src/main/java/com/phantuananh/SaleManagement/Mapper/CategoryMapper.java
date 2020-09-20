package com.phantuananh.SaleManagement.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.phantuananh.SaleManagement.DTO.CategoryDTO;
import com.phantuananh.SaleManagement.Entity.Category;

@Mapper
public interface CategoryMapper {
	
	CategoryDTO toCategoryDTO(Category categoryEntity);
	
	List<CategoryDTO> toCategoryDTOs(List<Category> category);
	
	Category toCategoryEntity(CategoryDTO categoryDTO);
}
