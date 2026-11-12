package com.service.main.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Setter
@Getter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_request_id",
                nullable = false, unique = true)
    private ServiceRequest serviceRequest;

    @Column(nullable = false)
    private BigDecimal amount;

    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status = PaymentStatus.PENDING;

    private LocalDateTime paymentDate;

    public Payment() {
    }

    
}
