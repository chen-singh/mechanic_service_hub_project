package com.service.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.service.main.entity.ServiceRequest;

import java.util.List;

public interface ServiceRequestRepository
        extends JpaRepository<ServiceRequest, Long> {

    List<ServiceRequest> findByCustomerId(Long customerId);

    List<ServiceRequest> findByStatus(
            com.service.main.entity.ServiceStatus status
    );
}