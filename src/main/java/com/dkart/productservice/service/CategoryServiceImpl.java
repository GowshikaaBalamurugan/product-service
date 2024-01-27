package com.dkart.productservice.service;

import com.dkart.productservice.entity.Category;
import com.dkart.productservice.exception.CategoryAlreadyExistsException;
import com.dkart.productservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    private final CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        if (categoryRepository.findByCategoryName(category.getCategoryName()).isPresent()){
            throw new CategoryAlreadyExistsException("Category Already Exists");
        }

        return categoryRepository.save(category);
    }
}