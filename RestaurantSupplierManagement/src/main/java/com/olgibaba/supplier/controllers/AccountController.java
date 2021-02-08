package com.olgibaba.supplier.controllers;

import com.olgibaba.supplier.buisness.entities.UserRestaurant;
import com.olgibaba.supplier.buisness.services.AccountService;
import com.olgibaba.supplier.persistence.AdminRepository;
import com.olgibaba.supplier.persistence.UserRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/restaurant")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserRestaurantRepository userRestaurantRepository;

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/signIn")
    public String signIn(@RequestBody UserRestaurant userRestaurant, Model model){

        userRestaurant = accountService.signIn(userRestaurant);
        model.addAttribute("userRestaurant", userRestaurant);

        if (userRestaurant.equals(null)){
            return "errorPage";
        }else{
            return "homepage";
        }

    }
    @PostMapping("/signUp")
    public String signUp(Model model){

        UserRestaurant userRestaurant = new UserRestaurant();
        model.addAttribute("user", userRestaurant);

        return "homepage";
    }

}
