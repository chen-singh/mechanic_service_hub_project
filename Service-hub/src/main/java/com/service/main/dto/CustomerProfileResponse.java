package com.service.main.dto;


public record CustomerProfileResponse(
        Long id,
        String name,
        String email,
        String phone,
        String role
) {}