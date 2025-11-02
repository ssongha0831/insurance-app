package com.dayone.insuranceapp.web.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRespDto {
    private long id;
    private String email;
    private String name; // 사용자 이름
    private UserRole role;
    private String password;
    private LocalDateTime createdAt; // 가입 일시
}
