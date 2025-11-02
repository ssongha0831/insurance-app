package com.dayone.insuranceapp.web.repository;

import com.dayone.insuranceapp.web.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String keyword);
    List<Product> findByBasePriceBetweenAndCategory(BigDecimal min, BigDecimal max, String category); // BigDecimal는 float/double 보다 훨씬 정밀한 계산 가능
}
