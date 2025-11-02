package com.dayone.insuranceapp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserListRespDto {
    private long id;
    private String email;
    private String name; // 사용자 이름
}
