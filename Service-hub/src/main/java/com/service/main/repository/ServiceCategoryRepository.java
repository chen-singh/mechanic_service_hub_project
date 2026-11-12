package com.service.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.service.main.entity.ServiceCategory;

public interface ServiceCategoryRepository
        extends JpaRepository<ServiceCategory, Long> {
}
