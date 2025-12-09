package com.ProductList.Product.Service;

import com.ProductList.Product.DTO.ProductDTO;
import com.ProductList.Product.Entity.CategoryEntity;
import com.ProductList.Product.Entity.ProductEntity;
import com.ProductList.Product.Mapper.ProductMapper;
import com.ProductList.Product.Repository.CategoryRepository;
import com.ProductList.Product.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public ProductDTO createProduct(ProductDTO productDto) {

        CategoryEntity category=categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(()-> new RuntimeException("category not found"));
        ProductEntity product= ProductMapper.toProductEntity(productDto,category);
         product= productRepository.save(product);
         return ProductMapper.toProductDTO(product);

    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id).stream().map(ProductMapper::toProductDTO).toList().get(0);
    }

    public void deleteProductById(Long id) {
        productRepository.findById(id).orElseThrow(()-> new RuntimeException("product not found"));
        productRepository.deleteById(id);
    }

    public ProductDTO updateProduct(ProductDTO productDto, Long id) {
      ProductEntity productEntity=  productRepository.findById(id).orElseThrow(()-> new RuntimeException("product not found"));
       CategoryEntity categoryEntity= categoryRepository.findById(productDto.getCategoryId()).orElseThrow(()-> new RuntimeException("category not found"));
        productEntity.setName(productDto.getName());
        productEntity.setCategory(categoryEntity);
        productEntity.setDescription(productDto.getDescription());
        productEntity.setPrice(productDto.getPrice());
        productRepository.save(productEntity);
        return ProductMapper.toProductDTO(productEntity);
    }
}
