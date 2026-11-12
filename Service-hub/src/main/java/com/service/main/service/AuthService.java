package com.service.main.service;



import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.service.main.dto.AuthResponse;
import com.service.main.dto.LoginRequest;
import com.service.main.dto.RegisterRequest;
import com.service.main.dto.UserResponse;
import com.service.main.entity.Role;
import com.service.main.entity.Users;
import com.service.main.repository.UserRepository;

import java.util.Locale;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // CUSTOMER REGISTRATION
    public UserResponse register(RegisterRequest request) {

        String email = request.email()
                .trim()
                .toLowerCase(Locale.ROOT);

        if (userRepository.existsByEmail(email)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email is already registered"
            );
        }

        Users user = new Users();

        user.setFullName(request.fullName().trim());
        user.setEmail(email);

        
        user.setPassword(
                passwordEncoder.encode(request.password())
        );

        user.setPhone(request.phone());

        // Never allow public registration as ADMIN
        user.setRole(Role.CUSTOMER);

        Users savedUser = userRepository.save(user);

        return convertToResponse(savedUser);
    }

    // LOGIN
    public AuthResponse login(LoginRequest request) {

        String email = request.email()
                .trim()
                .toLowerCase(Locale.ROOT);

        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "Invalid email or password"
                ));

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.password(),
                        user.getPassword()
                );

        if (!passwordMatches) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid email or password"
            );
        }

        UserResponse userResponse =
                convertToResponse(user);

        return new AuthResponse(
                "Login successful",
                userResponse
        );
    }

    
    private UserResponse convertToResponse(Users user) {

        return new UserResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPhone(),
                user.getRole()
        );
    }
}