package com.service.main.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    private Integer manufacturingYear;

    private String registrationNumber;

    private String vehicleType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Users customer;

    public Vehicle() {
    }

    // Generate getters and setters in IntelliJ.
}
