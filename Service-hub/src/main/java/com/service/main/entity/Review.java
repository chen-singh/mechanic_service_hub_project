package com.service.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Setter
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Users customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mechanic_id", nullable = false)
    private MechanicProfile mechanic;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_request_id", nullable = false, unique = true)
    private ServiceRequest serviceRequest;

    private Integer rating;

    private String comment;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Review() {
    }

    
}