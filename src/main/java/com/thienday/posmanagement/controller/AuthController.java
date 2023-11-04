package com.thienday.posmanagement.controller;

import com.thienday.posmanagement.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController extends BaseController{
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity doLogin(@RequestBody String loginString){
        return execute(t -> authService.generateToken(loginString),"Get token successfull");
    }
}
