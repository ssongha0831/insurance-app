package com.dayone.insuranceapp.web.domain;

import com.dayone.insuranceapp.web.dto.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id  // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String passwordHash; // 비밀번호 해시(암호화 저장)

    @Column(nullable = false)
    private String name; // 사용자 이름

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // DB에 문자열로 저장
    private UserRole role;

    private int age;

    private String region;

    private String carType;//차량

    @CreationTimestamp
    private LocalDateTime createdAt; // 가입 일시
}
