package com.service.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.main.entity.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    boolean existsByEmail(String email);
}
