package com.dayone.insuranceapp.web.service;

import com.dayone.insuranceapp.web.domain.User;
import com.dayone.insuranceapp.web.dto.*;
import com.dayone.insuranceapp.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserListRespDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> UserListRespDto.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .name(user.getName())
                        .build())
                .collect(Collectors.toList());

    }

    @Override
    public UserRespDto getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        return user.map(value -> UserRespDto.builder()
                .id(value.getId())
                .name(value.getName())
                .password(value.getPasswordHash())
                .role(value.getRole())
                .email(value.getEmail())
                .createdAt(value.getCreatedAt())
                .build()).orElse(null);
    }

    @Override
    public void createUser(UserCreateReqDto dto) {
        User createUser = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .passwordHash(passwordEncoder.encode(dto.getPassword()))
                .role(UserRole.USER)
                .build();
        userRepository.save(createUser);

    }

    @Override
    public void updateUser(UserUpdateReqDto dto) throws Exception {
        Optional<User> optionalUser = userRepository.findByEmail(dto.getEmail());
        if (optionalUser.isEmpty()) {
            throw new Exception("사용자 정보가 없습니다.");
        }
        //데이터값을 입력안하면 에러처리가 필요..

//        User updatedUser = User.builder()
//                .name(dto.getName())
//                .passwordHash(passwordEncoder.encode(dto.getPassword()))
//                .age(dto.getAge())
//                .carType(dto.getCarType())
//                .region(dto.getRegion())
//                .build();
        optionalUser.get().setName(dto.getName());
        optionalUser.get().setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        optionalUser.get().setAge(dto.getAge());
        optionalUser.get().setCarType(dto.getCarType());
        optionalUser.get().setRegion(dto.getRegion());
        userRepository.save(optionalUser.get());

    }
}
