package com.olgibaba.supplier.buisness.services;

import com.olgibaba.supplier.buisness.entities.Admin;
import com.olgibaba.supplier.buisness.entities.UserRestaurant;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    Admin signIn(Admin admin);
    UserRestaurant signIn(UserRestaurant userRestaurant);

    Admin signUp(Admin admin);
    UserRestaurant signUp(UserRestaurant userRestaurant);
}
