package com.phantuananh.SaleManagement.API;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phantuananh.SaleManagement.DTO.CategoryDTO;
import com.phantuananh.SaleManagement.Entity.Category;
import com.phantuananh.SaleManagement.Mapper.CategoryMapper;
import com.phantuananh.SaleManagement.Service.CategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryAPI {
	
	private final CategoryService categoryService;
	private final CategoryMapper categoryMapper;
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		return ResponseEntity.ok(categoryMapper.toCategoryDTOs(categoryService.listAll2()));
	}
	
	@PostMapping
	public ResponseEntity<CategoryDTO> cretae(@RequestBody CategoryDTO categoryDTO){
		categoryService.save2(categoryMapper.toCategoryEntity(categoryDTO));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);

        return ResponseEntity.ok(categoryMapper.toCategoryDTO(category.get()));
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
		Category categoryEntity = categoryMapper.toCategoryEntity(categoryDTO);
		categoryEntity.setId(id);;
		
		categoryService.save2(categoryEntity);
		
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryDTO);
	}
	 @DeleteMapping("/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	        categoryService.delete2(id);;

	        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	    }
}
