package com.digitallab.store.product.controller;

import com.digitallab.store.product.entity.Product;
import com.digitallab.store.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController
{   private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProduct()
    {   List<Product> products = productService.listAllProduct();
        if(products.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(products);
    }
}
