package com.ProductList.Product.Service;

import com.ProductList.Product.DTO.CategoryDTO;
import com.ProductList.Product.Entity.CategoryEntity;
import com.ProductList.Product.Mapper.CategoryMapper;
import com.ProductList.Product.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public  CategoryDTO createCategoryDTO(CategoryDTO categoryDto) {
        CategoryEntity categoryEntity= CategoryMapper.toCategoryEntity(categoryDto);
        categoryEntity= categoryRepository.save(categoryEntity);
        return CategoryMapper.toCategoryDTO(categoryEntity);
    }

    public List<CategoryDTO> getAllCategories() {
//        List<CategoryEntity> categoryEntity=categoryRepository.findAll();
//        List<CategoryDTO> categoryDTO=new ArrayList<>();
//        for(CategoryEntity categoryEntity1:categoryEntity){
//            categoryDTO.add(CategoryMapper.toCategoryDTO(categoryEntity1));
//        }
//        return categoryDTO;

//        Using Steams
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();

    }


    public CategoryDTO getElementByID(Long id) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseGet(CategoryEntity::new);
        return CategoryMapper.toCategoryDTO(category);

//        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
//        return CategoryMapper.toCategoryDTO(categoryEntity);
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("category not found"));
        categoryRepository.deleteById(id);
    }
}
