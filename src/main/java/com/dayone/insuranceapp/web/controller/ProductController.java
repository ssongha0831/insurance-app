package com.dayone.insuranceapp.web.controller;

import com.dayone.insuranceapp.web.dto.ProductListDto;
import com.dayone.insuranceapp.web.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor

public class ProductController {

    private final ProductServiceImpl productService;

    /**
     *
     * @return
     */
    @GetMapping("/list/all")
    public List<ProductListDto> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * 회원은 상품 목록을 조건(가격범위/보장키워드)으로 필터링한다.
     * @param minPrice 가격범위
     * @param maxPrice 가격범위
     * @param category 카테고리
     * @return 상품 목록
     */
    @GetMapping("/search")
    public List<ProductListDto> getProducts(@RequestParam BigDecimal minPrice,
                                            @RequestParam BigDecimal maxPrice,
                                            @RequestParam(required = false) String category) {
        return productService.getProductsBySearch(minPrice,maxPrice, category);
    }
}
