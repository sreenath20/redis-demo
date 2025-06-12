package com.example.redis_demo.service;

import com.example.redis_demo.model.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Cacheable(value = "products", key = "#id")
    public Product getProductById(Long id) {
        simulateSlowService();
        return new Product(id, "Spring with Redis", 450.0);
    }

    private void simulateSlowService() {
        try { Thread.sleep(3000); } catch (InterruptedException ignored) {}
    }
}
