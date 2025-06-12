package com.example.redis_demo.controller;

import com.example.redis_demo.model.Product;
import com.example.redis_demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")

public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getProductById(id);
    }
}
