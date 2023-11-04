package com.thienday.posmanagement.service;

import com.thienday.posmanagement.entity.User;
import com.thienday.posmanagement.response.UserResponse;

public interface UserService {
    UserResponse getUserInfo(String userName,String password);

    boolean checkUserFromToken(String userName,String password);
}
