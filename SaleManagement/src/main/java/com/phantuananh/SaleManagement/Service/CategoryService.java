package com.phantuananh.SaleManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phantuananh.SaleManagement.Entity.Category;
import com.phantuananh.SaleManagement.Entity.Product;
import com.phantuananh.SaleManagement.Repository.CategoryRepository;



@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> listAll2(){
		return categoryRepository.findAll();
	}
	
	public void save2(Category cartEntity) {
		categoryRepository.save(cartEntity);
	}
	
	
	
	public Category get2(Long id) {
		return categoryRepository.findById(id).get();
	}
	
	public void delete2(Long id) {
		categoryRepository.deleteById(id);
	}

	public List<Product> findbyCatId(Integer catid) {
		return categoryRepository.findByCartId((long)catid);
	}
	
	  public Optional<Category> findById(Long id) {
	        return categoryRepository.findById(id);
	    }
	
	public Category updateCategory(Category category) {
        Category existingCategory = categoryRepository.findById(category.getId()).orElse(null); 
        existingCategory.setDescription(category.getDescription());
        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }
}
