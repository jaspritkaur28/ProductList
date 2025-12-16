package com.ProductList.Product.Controller;

import com.ProductList.Product.DTO.CategoryDTO;
import com.ProductList.Product.Exception.CategoryAlreadyExistsException;
import com.ProductList.Product.Service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
     name="Category REST API CURD Operation",
        description = "CREATE,UPDATE,READ and DELETE operation for Category API"
)
@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {


    private CategoryService categoryService;
    //    Create Category
    @Operation(
            summary = "Create Category",
            description = "REST API to create Category"
    )
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


    @Operation(
            summary = "Fetch all Category",
            description = "REST API to Fetch all Category"
    )
//            Get Category
      @GetMapping("/allcategories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(),HttpStatus.OK);
      }

//      Get Category by Id
@Operation(
        summary = "Fetch Category by Id",
        description = "REST API to Fetch Category by Id"
)
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.getElementByID(id),HttpStatus.OK);
    }
    @Operation(
            summary = "Delete Category by id",
            description = "REST API to Delete Category by id"
    )
//    Delete category by id

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return "Successfully deleter";
    }

}
