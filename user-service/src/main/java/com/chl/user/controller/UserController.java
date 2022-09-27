package com.chl.user.controller;

import com.chl.user.common.ResponseResult;
import com.chl.user.domain.dto.UserLoginDTO;
import com.chl.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: share-project
 * @description:
 * @Author: 曹红亮
 * @create: 2022-09-06 14:20
 **/
@Slf4j
@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping("{id}")
    public ResponseResult getUserById(@PathVariable Integer id) {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw  new RuntimeException(e);
//        }
        return ResponseResult.success(userService.findById(id));
    }


    @PostMapping("/login")
    public ResponseResult getUserById(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.login(userLoginDTO);
    }
}
