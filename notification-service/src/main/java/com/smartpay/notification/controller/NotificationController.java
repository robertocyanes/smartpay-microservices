package com.smartpay.notification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @GetMapping("/notifications")
    public String test() {
        return "Notification Service OK";
    }
}