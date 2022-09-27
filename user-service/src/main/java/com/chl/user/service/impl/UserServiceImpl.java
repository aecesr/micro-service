package com.chl.user.service.impl;

import com.chl.user.common.ResponseResult;
import com.chl.user.domain.dto.UserLoginDTO;
import com.chl.user.domain.entity.User;
import com.chl.user.repository.UserRepository;
import com.chl.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.chl.user.common.ResultCode.USER_ACCOUNT_ERROR;


/**
 * @program: share-project
 * @description:
 * @Author: 曹红亮
 * @create: 2022-09-06 14:15
 **/
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Integer id) {

        return userRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseResult login(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByMobileAndPassword(userLoginDTO.getMobile(), userLoginDTO.getPassword());
        System.out.println(user);
        if (user == null) {
            return ResponseResult.failure(USER_ACCOUNT_ERROR);
        }
        return ResponseResult.success(user);
    }
}
