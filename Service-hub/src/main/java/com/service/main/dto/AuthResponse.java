package com.service.main.dto;


public record AuthResponse(
        String message,
        String accessToken,
        String tokenType,
        long expiresIn,
        UserResponse user
        
) {
}