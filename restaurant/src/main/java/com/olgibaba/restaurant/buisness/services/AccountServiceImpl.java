package com.olgibaba.restaurant.buisness.services;

import com.olgibaba.restaurant.buisness.entities.UserRestaurant;
import com.olgibaba.restaurant.buisness.payload.request.UserLoginRequest;
import com.olgibaba.restaurant.buisness.payload.request.UserSignUpRequest;
import com.olgibaba.restaurant.buisness.payload.response.ResponseMessages;
import com.olgibaba.restaurant.persistence.UserRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserRestaurantRepository userRestaurantRepository;

    /**
     * Method that compares the user coming from the app and the DB.
     * @param userRestaurant
     * @return A ResponseEntity with either the error status, header and message if the credentials are wrong, or an user.
     */
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

        return ResponseEntity.ok(userRestaurantOptional.get());

    }

    /**
     * Method that compares the user coming from the app and the DB.
     * @param userRestaurant
     * @return A ResponseEntity with either the error status, header and message if the user already exists, or an user.
     */
    @Override
    public ResponseEntity<?> signUp(UserSignUpRequest userRestaurant) {

        if (userRestaurantRepository.existsByMail(userRestaurant.getMail())){
            return ResponseEntity.badRequest().body(new ResponseMessages(400, "Error", "Email already exists"));
        }

        UserRestaurant newUserRestaurant = new UserRestaurant(
                userRestaurant.getMail(),
                userRestaurant.getPassword(),
                userRestaurant.getCountry(),
                userRestaurant.getPostcode(),
                userRestaurant.getCity(),
                userRestaurant.getAddress());

        userRestaurantRepository.save(newUserRestaurant);

        return ResponseEntity.ok(new ResponseMessages(200, "Ok", "Signed up successfully"));

    }


}
