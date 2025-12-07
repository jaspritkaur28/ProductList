package com.ProductList.Product.Mapper;

import com.ProductList.Product.DTO.ProductDTO;
import com.ProductList.Product.Entity.CategoryEntity;
import com.ProductList.Product.Entity.ProductEntity;

public class ProductMapper {
    public static ProductDTO toProductDTO(ProductEntity productEntity){
        return new ProductDTO(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getPrice(),
                productEntity.getDescription(),
                productEntity.getCategory().getCategoryId()
                );
    }

    public static ProductEntity toProductEntity(ProductDTO productDto, CategoryEntity category){
        ProductEntity productEntity= new ProductEntity();
        productEntity.setName(productDto.getName());
        productEntity.setCategory(category);
        productEntity.setPrice(productDto.getPrice());
        productEntity.setDescription(productDto.getDescription());
        return productEntity;
    }

}
