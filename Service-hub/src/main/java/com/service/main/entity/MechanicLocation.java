package com.service.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "mechanic_locations")
@Setter
@Getter
public class MechanicLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mechanic_id", nullable = false)
    private MechanicProfile mechanic;

    private Double latitude;

    private Double longitude;

    private LocalDateTime recordedAt;

    @PrePersist
    public void onCreate() {
        recordedAt = LocalDateTime.now();
    }

    public MechanicLocation() {
    }

   
}