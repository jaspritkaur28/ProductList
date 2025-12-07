package com.ProductList.Product.Controller;

import com.ProductList.Product.DTO.CategoryDTO;
import com.ProductList.Product.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {


    private CategoryService categoryService;
    @PostMapping
            public ResponseEntity<CategoryDTO> getCategoryDTO(@RequestBody CategoryDTO categoryDto){
              return new ResponseEntity<>(categoryService.getCategoryDTO(categoryDto), HttpStatus.CREATED);
            }


}
