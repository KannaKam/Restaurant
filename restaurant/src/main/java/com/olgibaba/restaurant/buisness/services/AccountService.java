package com.olgibaba.restaurant.buisness.services;

import com.olgibaba.restaurant.buisness.payload.request.UserLoginRequest;
import com.olgibaba.restaurant.buisness.payload.request.UserSignUpRequest;
import org.springframework.http.ResponseEntity;


public interface AccountService {

    ResponseEntity<?> signIn(UserLoginRequest userLoginRequest);

    ResponseEntity<?> signUp(UserSignUpRequest userSignUpRequest);
}
