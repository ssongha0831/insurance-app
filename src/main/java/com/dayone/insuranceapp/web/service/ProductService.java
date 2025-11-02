package com.dayone.insuranceapp.web.service;

import com.dayone.insuranceapp.web.dto.ProductListDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductListDto> getAllProducts();

    List<ProductListDto> getProductsBySearch(BigDecimal minPrice, BigDecimal  maxPrice, String category);
}
