package com.dayone.insuranceapp.web.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductListDto {
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
