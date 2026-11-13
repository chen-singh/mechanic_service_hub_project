package com.service.main.dto;

import com.service.main.entity.Role;

public record UserResponse(
        Long id,
        String fullName,
        String email,
        String phone,
        Role role
) {
}