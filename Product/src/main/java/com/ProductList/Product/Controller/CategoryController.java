package com.ProductList.Product.Controller;

import com.ProductList.Product.DTO.CategoryDTO;
import com.ProductList.Product.Exception.CategoryAlreadyExistsException;
import com.ProductList.Product.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {


    private CategoryService categoryService;
//    Create Category
    @PostMapping
            public ResponseEntity<?> createCategoryDTO(@RequestBody CategoryDTO categoryDto){
//           try{
//               CategoryDTO categorydto=categoryService.createCategoryDTO(categoryDto);
//               return new ResponseEntity<>(categorydto, HttpStatus.CREATED);
//           }catch(CategoryAlreadyExistsException e){
//              return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//           }

              return new ResponseEntity<>(categoryService.createCategoryDTO(categoryDto), HttpStatus.CREATED);
            }

//            Get Category
      @GetMapping("/allcategories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(),HttpStatus.OK);
      }

//      Get Category by Id

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.getElementByID(id),HttpStatus.OK);
    }

//    Delete category by id
    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
    }

}
