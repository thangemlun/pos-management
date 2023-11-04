package com.thienday.posmanagement.util;

import com.thienday.posmanagement.response.UserResponse;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserSessionUtil {
    public static UserResponse getUser(){
        return (UserResponse) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
    }
}
