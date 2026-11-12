package com.service.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.main.entity.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByCustomerId(Long customerId);
}
