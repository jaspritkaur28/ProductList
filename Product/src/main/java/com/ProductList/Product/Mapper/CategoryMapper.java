package com.ProductList.Product.Mapper;

import com.ProductList.Product.DTO.CategoryDTO;
import com.ProductList.Product.Entity.CategoryEntity;

public class CategoryMapper {

    public static CategoryDTO toCategoryDTO(CategoryEntity categoryEntity){
       if(categoryEntity == null){
           return null;
       }
       CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryEntity.getCategoryId());
        categoryDTO.setName(categoryEntity.getCategoryName());
        categoryDTO.setProduct(categoryEntity.getProduct().stream().
               map(ProductMapper::toProductDTO).toList());
        return categoryDTO;
    }
    public static CategoryEntity toCategoryEntity(CategoryDTO categoryDto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(categoryDto.getName());
        return categoryEntity;
    }
}
