package com.chl.user.service;

import com.chl.user.common.ResponseResult;
import com.chl.user.domain.dto.UserLoginDTO;
import com.chl.user.domain.entity.User;


public interface UserService {
    User findById(Integer id);
    ResponseResult login(UserLoginDTO userLoginDTO);
}
