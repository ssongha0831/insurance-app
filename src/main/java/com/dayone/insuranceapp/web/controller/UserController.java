package com.dayone.insuranceapp.web.controller;

import com.dayone.insuranceapp.web.dto.UserCreateReqDto;
import com.dayone.insuranceapp.web.dto.UserListRespDto;
import com.dayone.insuranceapp.web.dto.UserRespDto;
import com.dayone.insuranceapp.web.dto.UserUpdateReqDto;
import com.dayone.insuranceapp.web.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/list/all")
    public List<UserListRespDto> getAllUserList() {
        return userService.getAllUsers();
    }

    @GetMapping
    public UserRespDto getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public void createUser(@RequestBody UserCreateReqDto dto) {
        userService.createUser(dto);
    }

    @PutMapping
    public void updateUser(@RequestBody UserUpdateReqDto dto) throws Exception{
        userService.updateUser(dto);
    }

}
