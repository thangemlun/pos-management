package com.thienday.posmanagement.service.impl;

import com.sun.xml.messaging.saaj.util.Base64;
import com.thienday.posmanagement.authentication.TokenProvider;
import com.thienday.posmanagement.repository.UserRepository;
import com.thienday.posmanagement.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private TokenProvider tokenProvider;
    @Override
    public String generateToken(String loginString) {
        try {
            String loginDecoded = Base64.base64Decode(loginString);
            String[] users = loginDecoded.split(",");
            if(userRepo.isExistUserInfoByUserNameAndPassword(users[0],users[1])){
                return tokenProvider.generateToken(userRepo.getUserInfoByUserNameAndPassword(users[0],users[1]));
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }
}
