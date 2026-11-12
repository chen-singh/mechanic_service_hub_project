package com.service.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.main.entity.MechanicProfile;

public interface MechanicProfileRepository
        extends JpaRepository<MechanicProfile, Long> {
}
