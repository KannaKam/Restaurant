package com.olgibaba.restaurant.buisness.services;

import com.olgibaba.restaurant.payload.request.AdminLoginRequest;
import com.olgibaba.restaurant.payload.request.UserLoginRequest;
import com.olgibaba.restaurant.payload.request.UserSignUpRequest;
import org.springframework.http.ResponseEntity;


public interface AccountService {

    ResponseEntity<?> signIn(AdminLoginRequest admin);
    ResponseEntity<?> signIn(UserLoginRequest userLoginRequest);

    ResponseEntity<?> signUp(UserSignUpRequest userSignUpRequest);
}
