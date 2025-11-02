package com.dayone.insuranceapp.web.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Product {

    @Id  // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String name;
    private String category;
    private BigDecimal basePrice;
    private int ageMin;
    private int ageMax;
    private String vehicleType;
    private float regionWeight;
    private float coverageScore;
    private float rating;
    private boolean isActive;
    @CreationTimestamp
    //@CreatedDate
    private LocalDateTime createdAt;

}
