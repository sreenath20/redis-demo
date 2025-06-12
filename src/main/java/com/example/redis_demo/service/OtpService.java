package com.example.redis_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class OtpService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void storeOtp(String phone, String otp) {
        redisTemplate.opsForValue().set("otp:" + phone, otp, 1, TimeUnit.MINUTES);
    }

    public boolean verifyOtp(String phone, String otp) {
        String saved = redisTemplate.opsForValue().get("otp:" + phone);
        return otp.equals(saved);
    }
}
