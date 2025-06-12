package com.example.redis_demo.controller;


import com.example.redis_demo.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/send")
    public String sendOtp(@RequestParam String phone) {
        String otp = String.format("%06d", new Random().nextInt(999999));
        otpService.storeOtp(phone, otp);
        return "OTP sent: " + otp;
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String phone, @RequestParam String otp) {
        return otpService.verifyOtp(phone, otp) ? "Valid" : "Invalid";
    }
}
