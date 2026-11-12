package com.service.main.controller;



import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProtectedTestController {

    @GetMapping("/customer/test")
    public String customerTest() {
        return "Welcome Customer! Access granted.";
    }

    @GetMapping("/mechanic/test")
    public String mechanicTest() {
        return "Welcome Mechanic! Access granted.";
    }

    @GetMapping("/admin/test")
    public String adminTest() {
        return "Welcome Admin! Access granted.";
    }
}