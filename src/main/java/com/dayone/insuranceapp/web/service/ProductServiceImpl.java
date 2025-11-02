package com.dayone.insuranceapp.web.service;

import com.dayone.insuranceapp.web.domain.Product;
import com.dayone.insuranceapp.web.dto.ProductListDto;
import com.dayone.insuranceapp.web.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // 생성자 주입 자동화
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public List<ProductListDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> ProductListDto.builder()
                        .id(product.getId())
                        .basePrice(product.getBasePrice())
                        .name(product.getName())
                        .company(product.getCompany())
                        .ageMax(product.getAgeMax())
                        .ageMin(product.getAgeMin())
                        .category(product.getCategory())
                        .coverageScore(product.getCoverageScore())
                        .rating(product.getRating())
                        .regionWeight(product.getRegionWeight())
                        .vehicleType(product.getVehicleType())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductListDto> getProductsBySearch(BigDecimal minPrice, BigDecimal  maxPrice, String category) {
        List<Product> products = productRepository.findByBasePriceBetweenAndCategory(minPrice, maxPrice, category);
        return products.stream()
                .map(product -> ProductListDto.builder()
                        .id(product.getId())
                        .basePrice(product.getBasePrice())
                        .name(product.getName())
                        .company(product.getCompany())
                        .ageMax(product.getAgeMax())
                        .ageMin(product.getAgeMin())
                        .category(product.getCategory())
                        .coverageScore(product.getCoverageScore())
                        .rating(product.getRating())
                        .regionWeight(product.getRegionWeight())
                        .vehicleType(product.getVehicleType())
                        .build())
                .collect(Collectors.toList());
    }
}
