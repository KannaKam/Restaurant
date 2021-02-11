package com.olgibaba.restaurant.buisness.services;

import com.olgibaba.restaurant.buisness.entities.Admin;
import com.olgibaba.restaurant.buisness.entities.UserRestaurant;
import com.olgibaba.restaurant.payload.jsonWebToken.JWToken;
import com.olgibaba.restaurant.payload.request.AdminLoginRequest;
import com.olgibaba.restaurant.payload.request.UserLoginRequest;
import com.olgibaba.restaurant.payload.request.UserSignUpRequest;
import com.olgibaba.restaurant.payload.response.ResponseMessages;
import com.olgibaba.restaurant.persistence.AdminRepository;
import com.olgibaba.restaurant.persistence.UserRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserRestaurantRepository userRestaurantRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    JWToken jwToken;


    @Override
    public ResponseEntity<?> signIn(AdminLoginRequest admin) {

        if(!adminRepository.existsByMail(admin.getMail())){
            return ResponseEntity.badRequest().body(new ResponseMessages(400, "Error", "Current email does not exist."));
        }

        Optional<Admin> adminOptional = adminRepository.findAdminByMail(admin.getMail());

        if (adminOptional.isPresent()){
            if(!admin.getPassword().equals(adminOptional.get().getPassword())){
                return ResponseEntity.badRequest().body(new ResponseMessages(400, "Error", "Wrong credentials."));
            }
        }
        
        return ResponseEntity.ok(jwToken.generateToken(admin.getMail()));
    }

    @Override
    public ResponseEntity<?> signIn(UserLoginRequest userRestaurant) {

        if(!userRestaurantRepository.existsByMail(userRestaurant.getMail())){
            return ResponseEntity.badRequest().body(new ResponseMessages(400, "Error", "Wrong credentials."));
        }

        Optional<UserRestaurant> userRestaurantOptional = userRestaurantRepository.findUserRestaurantByMail(userRestaurant.getMail());

        if (userRestaurantOptional.isPresent()){
            if(!userRestaurant.getPassword().equals(userRestaurantOptional.get().getPassword())){
                return ResponseEntity.badRequest().body(new ResponseMessages(400, "Error", "Wrong credentials."));
            }
        }

        return ResponseEntity.ok(jwToken.generateToken(userRestaurant.getMail()));

    }

    @Override
    public ResponseEntity<?> signUp(UserSignUpRequest userRestaurant) {

        if (userRestaurantRepository.existsByMail(userRestaurant.getMail())){
            return ResponseEntity.badRequest().body(new ResponseMessages(400, "Error", "Email alredy exists"));
        }

        UserRestaurant newUserRestaurant = new UserRestaurant(
                userRestaurant.getMail(),
                userRestaurant.getPassword(),
                userRestaurant.getCountry(),
                userRestaurant.getPostcode(),
                userRestaurant.getCity(),
                userRestaurant.getAddress());

        userRestaurantRepository.save(newUserRestaurant);

        return ResponseEntity.ok(new ResponseMessages(200, "Ok", "Signed up succesfully"));

    }


}
