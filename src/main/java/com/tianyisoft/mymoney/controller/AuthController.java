package com.tianyisoft.mymoney.controller;

import com.tianyisoft.mymoney.pojo.Token;
import com.tianyisoft.mymoney.pojo.UserPojo;
import com.tianyisoft.mymoney.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianyi
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/authorize")
    public Token authorize(@RequestBody UserPojo userPojo) {
        return authService.authorize(userPojo);
    }
}
