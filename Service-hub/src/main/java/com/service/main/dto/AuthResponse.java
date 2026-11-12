package com.service.main.dto;


public record AuthResponse(
        String message,
        UserResponse user
) {
}