package com.example.redis_demo.controller;

import com.example.redis_demo.service.RateLimiterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api")
public class RateLimitController {

    @Autowired
    private  RateLimiterService limiter;

    @GetMapping("/limited")
    public ResponseEntity<String> rateLimited(@RequestParam String user) {
        if (limiter.allowRequest(user)) {
            return ResponseEntity.ok("Request allowed");
        } else {
            return ResponseEntity.status(429).body("Too many requests");
        }
    }
}
