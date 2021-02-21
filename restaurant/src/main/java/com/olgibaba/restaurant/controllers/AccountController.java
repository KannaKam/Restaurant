package com.olgibaba.restaurant.controllers;

import com.olgibaba.restaurant.buisness.services.AccountService;
import com.olgibaba.restaurant.buisness.payload.request.UserLoginRequest;
import com.olgibaba.restaurant.buisness.payload.request.UserSignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/userSignIn")
    public ResponseEntity<?> signIn (@RequestBody UserLoginRequest userLoginRequest){

        return this.accountService.signIn(userLoginRequest);

    }

    @PostMapping("/userSignUp")
    public ResponseEntity<?> signUp (@RequestBody UserSignUpRequest userSignUpRequest){

        return this.accountService.signUp(userSignUpRequest);
    }

}
