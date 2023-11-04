package com.thienday.posmanagement.controller;

import com.thienday.posmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("/user-info")
    public ResponseEntity getUserInfo(){
        return execute(t -> userService.getUserInfo(null,null),"Get user info successfully !");
    }
}
