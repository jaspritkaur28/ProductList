package com.ProductList.Product.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade =CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ProductEntity> product= new ArrayList<>();
}
