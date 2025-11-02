package com.dayone.insuranceapp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateReqDto {
    private String email;
    private String name; // 사용자 이름
    private String password;
    private int age;
    private String region;
    private String carType;
}
