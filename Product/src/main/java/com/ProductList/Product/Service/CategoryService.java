package com.ProductList.Product.Service;

import com.ProductList.Product.DTO.CategoryDTO;
import com.ProductList.Product.Entity.CategoryEntity;
import com.ProductList.Product.Mapper.CategoryMapper;
import com.ProductList.Product.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public  CategoryDTO getCategoryDTO(CategoryDTO categoryDto) {
        CategoryEntity categoryEntity= CategoryMapper.toCategoryEntity(categoryDto);
        categoryEntity= categoryRepository.save(categoryEntity);
        return CategoryMapper.toCategoryDTO(categoryEntity);
    }
}
