package com.ProductList.Product.Controller;

import com.ProductList.Product.DTO.ProductDTO;
import com.ProductList.Product.Service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name="Product REST API CURD Operation",
        description = "CREATE,UPDATE,READ and DELETE operation for Product API"
)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    @Operation(
            summary = "Create new product",
            description = "REST API to Create new product"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDto){
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }
    @Operation(
            summary = "Fetch all product",
            description = "REST API to Fetch all product"
    )
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }
    @Operation(
            summary = "Fetch Product by Id",
            description = "REST API to Fetch Product by Id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }
    @Operation(
            summary = "Update Product by Id",
            description = "REST API to update Product by Id"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDto, @PathVariable Long id){
        return new ResponseEntity<>(productService.updateProduct(productDto,id),HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Product by id",
            description = "REST API to Delete Product by id"
    )
    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }
}
