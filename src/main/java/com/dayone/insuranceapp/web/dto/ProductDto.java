package com.dayone.insuranceapp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

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
    private LocalDateTime createdAt;
}
