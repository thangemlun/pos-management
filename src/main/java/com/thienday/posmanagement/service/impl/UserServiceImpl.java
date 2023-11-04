package com.thienday.posmanagement.service.impl;

import com.thienday.posmanagement.entity.User;
import com.thienday.posmanagement.repository.UserRepository;
import com.thienday.posmanagement.response.UserResponse;
import com.thienday.posmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse getUserInfo(String userName,String password) {
        UserResponse userInfo = UserResponse.toResponse(userRepository.getUserInfoByUserNameAndPassword(userName,password));
        return userInfo;
    }

    @Override
    public boolean checkUserFromToken(String userName, String password) {
        return userRepository.isExistUserInfoByUserNameAndPassword(userName,password);
    }
}
