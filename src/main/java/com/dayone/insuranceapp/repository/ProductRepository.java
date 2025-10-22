package com.dayone.insuranceapp.repository;

import com.dayone.insuranceapp.domain.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
//import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

//@Entity
//@Table(name="product")

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String keyword);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max); // BigDecimal는 float/double 보다 훨씬 정밀한 계산 가능
}
