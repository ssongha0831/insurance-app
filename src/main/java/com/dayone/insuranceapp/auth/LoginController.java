package com.dayone.insuranceapp.auth;

import com.dayone.insuranceapp.web.dto.UserReqDto;
import com.dayone.insuranceapp.web.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserReqDto loginUser) {
        return userRepository.findByEmail(loginUser.getEmail())
                .map(user -> {
                    if (passwordEncoder.matches(loginUser.getPassword(), user.getPasswordHash())) {
                        return ResponseEntity.ok("로그인 성공");
                    } else {
                        return ResponseEntity.status(401).body("비밀번호가 일치하지 않습니다.");
                    }
                })
                .orElse(ResponseEntity.status(404).body("존재하지 않는 이메일입니다."));
    }
}
