package com.smartpay.payment.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @GetMapping
    public String health() {
        return "Payment OK";
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody Map<String, Object> req) {
        Map<String, Object> res = new HashMap<>();
        res.put("status", "SUCCESS");
        res.put("data", req);
        return res;
    }
}