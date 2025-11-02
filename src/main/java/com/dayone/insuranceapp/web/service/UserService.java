package com.dayone.insuranceapp.web.service;

import com.dayone.insuranceapp.web.dto.UserCreateReqDto;
import com.dayone.insuranceapp.web.dto.UserRespDto;
import com.dayone.insuranceapp.web.dto.UserListRespDto;
import com.dayone.insuranceapp.web.dto.UserUpdateReqDto;

import java.util.List;

public interface UserService {

    List<UserListRespDto> getAllUsers();

    UserRespDto getUserByEmail(String email);

    void createUser(UserCreateReqDto dto);

    void updateUser(UserUpdateReqDto dto) throws Exception;
}
