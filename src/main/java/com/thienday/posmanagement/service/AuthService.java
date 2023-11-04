package com.thienday.posmanagement.service;

public interface AuthService {
    String generateToken(String loginString);
}
