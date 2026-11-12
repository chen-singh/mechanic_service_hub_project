package com.service.main.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "mechanic_profiles")
@Setter
@Getter
public class MechanicProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private Users user;

    private String specialization;

    private Integer experienceYears;

    private String address;

    private BigDecimal hourlyRate;

    private boolean available = false;

    private boolean verified = false;

    public MechanicProfile() {
    }

}